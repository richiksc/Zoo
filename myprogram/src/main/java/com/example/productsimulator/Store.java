package com.example.productsimulator;

/**
 * A simulation of a store that buys and stocks products, and sells one every business day
 * until they go bankrupt.
 */
public class Store {

  public static final double INITIAL_CAPITAL = 50;

  public static void main(String[] args) {

    // Test a few methods (getRandomInRange and genRandSku)
    System.out.println("Product.genRandSku() = " + Product.genRandSku());
    System.out.println("Util.getRandomInRange() = " + Integer.toString(Util
        .getRandomInRange(5, 20)));
    System.out.println("");

    // Define variables
    boolean isBankrupt = false;
    int day = 1;
    Inventory inventory = new Inventory();

    // Receive the capital
    System.out.println("Receiving Capital, $" + Double.toString(INITIAL_CAPITAL));
    inventory.adjustRevenue(INITIAL_CAPITAL);
    System.out.println("Revenue at opening: " + inventory.getRevenue());

    System.out.println("");

    // Create the products
    Product  weights = new Product(5.99, "Barbells 10lb", 2.99),
        gameConsole = new Product(120D, "SSGL JETPLANE one", 70D);
    Food spinach = new Food(0.99, 1, "Fresh Spinach (Bulk)", 0.1, Food.FoodType.VEGETABLE);
    Apple bakingApples = new Apple(0.50, 9, "Granny Smith", 0.10);
    System.out.println(weights);
    System.out.println(gameConsole);
    System.out.println(spinach);
    System.out.println(bakingApples);

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
        System.out.format("%nYou are in debt!%n%n");
        isBankrupt = true;
      } else if(rev == 0) {
        System.out.format("%nYou went bankrupt on day %d!%n%n", day);
        isBankrupt = true;
      } else {
        System.out.format("%nYou survived day %d of business.%n%n", day);
      }
      System.out.println("Inventory 1 = " + inventory.get(1).toString());

    }

  }

}
