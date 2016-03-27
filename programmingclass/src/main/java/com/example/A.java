package com.example;

/**
 * Created by Richik SC on 2/28/2016.
 * A test class to learn about static variables.
 * Bad code on purpose.
 */
public class A {
  public static void main(String[] args) {
    A a1 = new A();
    A a2 = new A();
    a1.i = 15;
    a2.j = 30;
    a2.i = 60;
    System.out.println(a1.i);
    System.out.println(a1.j);
    System.out.println(a2.i);
    System.out.println(a2.j);
  }
  public static int i = 10;
  public int j;
}
