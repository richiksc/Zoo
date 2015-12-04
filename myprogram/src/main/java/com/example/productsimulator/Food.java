package com.example.productsimulator;

/**
 * Created by Owner on 11/27/2015.
 */
public class Food extends Product {
  private FoodType type;
  // private NutritionInfo nutritionInfo;
  public Food(String sku, double price, int quantity, String name, double mfrPrice, FoodType type
   /*,NutritionInfo
  nutrition*/) {
    super(sku, price * quantity, "Food, " + type.toString() + " - " + name, mfrPrice);
    this.type = type;
//    this.nutritionInfo = nutrition;
  }

  public Food(double price, int quantity, String name, double mfrPrice, FoodType type) {
    super(price * quantity, "Food, " + type.toString() + " - " + name, mfrPrice);
    this.type = type;
//    this.nutritionInfo = nutrition;
  }

  public enum FoodType {
    FRUIT, VEGETABLE, GRAIN, PROTEIN, DAIRY, OTHER
  }

  public FoodType getType() {
    return type;
  }

  /*public NutritionInfo getNutritionInfo() {
    return nutritionInfo;
    }*/
}
