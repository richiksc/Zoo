package com.example.productsimulator;

import java.util.Random;

/**
 * Created by Richik SC on 12/2/2015.
 */
public class Util {
  public static int getRandomInRange(int min, int max) {
    Random rand = new Random();
    return rand.nextInt((max - min) + 1) + min;
  }
}
