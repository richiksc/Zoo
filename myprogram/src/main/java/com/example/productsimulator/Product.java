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

  /**
   * Updates the retail price of the product, which will be used to add to revenue.
   * @param price
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * Returns the descriptive name of the product which is understandable by humans.
   * @return The product name
   */
  public String getName() {
    return name;
  }

  public double getMfrPrice() {
    return mfrPrice;
  }

  @Override
  public String toString() {
    return String.format("Product #%s | %-50s | %.2f", getSku(), getName(), getPrice());
  }

  /**
   * Generates a random six-digit SKU (Stock-Keeping Unit) for referring to the product in the
   * inventory (<code>Inventory</code>)
   * @see Inventory
   * @return
   */
  public static String genRandSku() {
    int prodNum = Util.getRandomInRange(0, 999999);
    String id = String.format("%06d", prodNum);
    return id;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
