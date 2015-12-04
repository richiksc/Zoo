package com.example.productsimulator;

/**
 * Created by Owner on 11/27/2015.
 */
public class Product {
  private String sku;
  private double price;
  private double mfrPrice;
  private String name;

  public Product(String sku, double price, String name, double mfrPrice) {
    this.sku = sku;
    this.price = price;
    this.name = name;
    this.mfrPrice = mfrPrice;
  }

  public Product(double price, String name, double mfrPrice) {
    this.sku = genRandSku();
    this.price = price;
    this.name = name;
    this.mfrPrice = mfrPrice;
  }

  public String getSku() {
    return sku;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getMfrPrice() {
    return mfrPrice;
  }

  @Override
  public String toString() {
    return "Product #" + this.getSku() + " | " +
        this.getName() + " | " +
        "$" + Double.toString(this.getPrice());
  }

  public static String genRandSku() {
    String id = Integer.toString(Util.getRandomInRange(0, 999999));
    if (id.length() < 6) {
      String zeroes = new String();
      for (int i = 0; i < 6 - id.length(); i++) {
        zeroes += "0";
      }
      id = zeroes + id;
    }

    return id;
  }
}
