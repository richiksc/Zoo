package com.example.productsimulator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Richik SC on 12/1/2015.
 */
public class Inventory {
  private ArrayList<Product> stock;
  private double revenue;
  public Inventory() {
    stock = new ArrayList<>();
  }
  public Inventory(Product[] productsArray) {
    stock = new ArrayList<>(productsArray.length);
    for (Product product : productsArray) {
      stock.add(product);
    }
  }

  public double getRevenue() {
    return revenue;
  }

  public void adjustRevenue(double difference) { revenue += difference; }

  public void sell(Product p)  throws Exception {
    if(stock.contains(p)) {
      revenue += p.getPrice();
      stock.remove(p);
    } else {
      throw new Exception("You tried to sell a product you don't have in stock!");
    }
  }

  public void sell(int i) throws ArrayIndexOutOfBoundsException {
    if(stock.size() > i) {
      Product p = stock.get(i);
      revenue += p.getPrice();
      stock.remove(i);
    } else {
      throw new ArrayIndexOutOfBoundsException("You tried to sell a product you don't have in stock!");
    }
  }

  public void add(Product p) {
    stock.add(p);
    revenue -= p.getMfrPrice();
  }

  public void add(Product[] products) {
    for (Product product : products) {
      stock.add(product);
      revenue -= product.getMfrPrice();
    }

  }

  public void add(Product p, int quantity) {
    for (int i = 0; i < quantity; i++) {
      stock.add(p);
      revenue -= p.getMfrPrice();
    }
  }

  public Product get(int i) {
    return stock.get(i);
  }

  public String[] getNameArray() {
    String[] names = new String[stock.size()];
    for (int i = 0; i < stock.toArray().length; i++)
      names[i] = stock.get(i).getName();
    return names;
  }

  public Object[] toArray() {
    return stock.toArray();
  }

  public int size() {
    return stock.size();
  }
}
