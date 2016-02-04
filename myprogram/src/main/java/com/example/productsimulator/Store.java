package com.example.productsimulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * A simulation of a store that buys and stocks products, and sells one every business day
 * until they go bankrupt.
 */
public class Store {

  public static void main(String[] args) {
    String cmd;
    Scanner scanner;
    Store myStore = new Store();
    boolean exit = false;

    scanner = new Scanner(System.in);

    System.out.println("Would you like to `run` the simulation, `test` the methods, get `info` " +
        "about the products or `exit`?");
    while (!exit) {
      System.out.print("> ");
      cmd = scanner.nextLine();
      switch (cmd) {
        case "run":
          System.out.print("Initial seed capital: ");
          double iCap = Double.parseDouble(scanner.nextLine());
          try {
            testMethods(false);
          } catch (Exception e) {
            e.printStackTrace();
            continue;
          }
          try {
            myStore.runSimulation(iCap);
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;
        case "test":
          try {
            testMethods(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;
        case "exit":
          System.out.println("Are you sure you want to exit?");
          System.out.print("y/n? ");
          if (scanner.nextLine().equals("y")) {
            exit = true;
          } else {
            continue;
          }
          break;
        case "info":
          Product weights = new Product(5.99, "Barbells 10lb", 2.99),
              gameConsole = new Product(120D, "SSGL JETPLANE one", 70D);
          Food spinach = new Food(0.99, 1, "Fresh Spinach (Bulk)", 0.1, Food.FoodType.VEGETABLE);
          Apple bakingApples = new Apple(0.50, 9, "Granny Smith", 0.10);
          System.out.println(weights);
          System.out.println(gameConsole);
          System.out.println(spinach);
          System.out.println(bakingApples);
          break;
        default:
          System.out.println("Not a valid command!");
          break;
      }
    }

    System.out.println("Exiting...");
    System.exit(0);

    // myStore.runSimulation(100);
  }

  public static void testMethods(boolean verbose) throws Exception {
    // Test a few methods (getRandomInRange and genRandSku)
    if(verbose) {
      System.out.println("Product.genRandSku() = " + Product.genRandSku());
      System.out.println("Util.getRandomInRange() = " + Integer.toString(Util
          .getRandomInRange(5, 20)));
    } else {
      if (Product.genRandSku() == null ||
          Util.getRandomInRange(5, 20) < 5 ||
          Util.getRandomInRange(5, 20) > 20) {
        throw new Exception("Methods did not work!");
      }
    }
  }

  public void runSimulation(double capital) throws IOException {
    // Define variables
    boolean isBankrupt = false;
    int day = 1;
    Inventory inventory = new Inventory();
    File results = new File("Results.txt");
    if(!results.exists()) {
      results.createNewFile();
    }
    FileWriter writer = new FileWriter(results);

    inventory.adjustRevenue(capital);
    System.out.println("Revenue at opening: " + inventory.getRevenue());

    System.out.println("");

    // Create the products
    Product  weights = new Product(5.99, "Barbells 10lb", 2.99),
        gameConsole = new Product(120D, "SSGL JETPLANE one", 70D);
    Food spinach = new Food(0.99, 1, "Fresh Spinach (Bulk)", 0.1, Food.FoodType.VEGETABLE);
    Apple bakingApples = new Apple(0.50, 9, "Granny Smith", 0.10);

    while (!isBankrupt) {
      inventory.add(new Product[]{weights, gameConsole, spinach, bakingApples});

      System.out.println("\nRevenue after adding products: " + inventory.getRevenue());

      // Sell a random product
      int randProductId = Util.getRandomInRange(0, inventory.size());
      System.out.println("Selling Product... " + inventory.get(randProductId).getName());
      try {
        inventory.sell(randProductId);
      } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
      }

      double rev = inventory.getRevenue();
      System.out.println("rev = " + rev);
      if(rev < 0) {
        System.out.format("%nYou are in debt on day %d!%n%n", day);
        writer.write("d" + String.valueOf(day) + "\n");
        writer.flush();
        writer.close();
        isBankrupt = true;
      } else if(rev == 0) {
        System.out.format("%nYou went bankrupt on day %d!%n%n", day);
        writer.write("b" + String.valueOf(day) + "\n");
        writer.flush();
        writer.close();
        isBankrupt = true;
      } else {
        System.out.format("%nYou survived day %d of business.%n%n", day);
        day++;
      }
      //      System.out.println("Inventory 1 = " + inventory.get(1).toString());

    }
  }

}
