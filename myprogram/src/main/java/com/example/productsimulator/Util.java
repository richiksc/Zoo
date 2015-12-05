package com.example.productsimulator;

import java.util.Random;

/**
 * A collection of utilities used in ProductSimulator classes.
 * Created by Richik SC on 12/2/2015.
 */
public class Util {
  /**
   * A helper method that generates a random integer between a given minimum and maximum value.
   * @param min
   * @param max
   * @return <code>int randomInt</code>
   */
  public static int getRandomInRange(int min, int max) {
    Random rand = new Random();
    return rand.nextInt(max - min) + min;
  }
}
