package com.example.productsimulator;

public class Program {

  public static final double INITIAL_CAPITAL = 50;

  public static void main(String[] args) {
    
    // Test some stuff
    System.out.println("Product.genRandSku() = " + Product.genRandSku());
    System.out.println("Util.getRandomInRange() = " + Integer.toString(Util
        .getRandomInRange(5, 20)));
    System.out.println("");

    // Get set up
    Inventory inventory = new Inventory();
    System.out.println("Receiving Capital, $" + Double.toString(INITIAL_CAPITAL));
    inventory.adjustRevenue(INITIAL_CAPITAL);
    System.out.println("");

    // Create the products
    Product weights = new Product(5.99, "Barbells 10lb", 2.99);
    inventory.add(weights);
    System.out.println(inventory.get(0).toString());

    inventory.add(new Food(0.99, 5, "Fresh Spinach (Bulk)", Food.FoodType.VEGETABLE, 0.1));
    System.out.println(inventory.get(1).toString());
    
    inventory.add(new Apple(0.50, 4, "Granny Smith"));
    System.out.println(inventory.get(2).toString());

    inventory.add(new Product(120D, "SSGL JETPLANE one"));
    System.out.println(inventory.get(3).toString());

    System.out.println("Inventory 1 = " + inventory.get(1).toString());

    int randProductId = Util.getRandomInRange(0, inventory.size());

    System.out.println("Selling Product... " + inventory.get(randProductId).getName());
    try {
      inventory.sell(randProductId);
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
    System.out.println("Inventory 1 = " + inventory.get(1).toString());

  }

}
