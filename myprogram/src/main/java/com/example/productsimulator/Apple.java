package com.example.productsimulator;

/**
 * Created by Owner on 11/29/2015.
 */
public class Apple extends Food {
  private String variety;

  public Apple(String sku, double price, int quantity, String appleVariety) {
    super(sku, price, quantity, appleVariety + " Apple", FoodType.FRUIT);
    this.variety = appleVariety;
  }

  public Apple(double price, int quantity, String appleVariety) {
    super(price, quantity, appleVariety + " Apple", FoodType.FRUIT);
    this.variety = appleVariety;
  }

  public String getVariety() {
    return variety;
  }
}
