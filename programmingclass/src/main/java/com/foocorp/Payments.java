package com.foocorp;

/**
 * Created by Richik SC on 3/27/2016.
 * A class to help calculate the wages of Foo Corporation's workers.
 */
public class Payments {

  public static void main(String[] args) {
    Payments fCPayments = new Payments(8, 60, 1.5);
    System.out.println("Hrs                 Paid");
    for (String s : args) {
      int hrs = Integer.parseInt(s);
      fCPayments.payWorker(hrs);
    }
  }

  private int hrlyWage;
  private int maxHours;
  private double overtimeRate;

  Payments(int minWage, int maxHours, double overtimeRate) {
    this.hrlyWage = minWage;
    this.maxHours = maxHours;
    this.overtimeRate = overtimeRate;
  }

  public double calculatePay(double hoursWorked) {
    if (hoursWorked >= 40 && hoursWorked <= 60) {
      return hoursWorked * (overtimeRate * hrlyWage);
    } else if (hoursWorked > 60) {
      return 60 * (overtimeRate * hrlyWage);
    } else {
      return hoursWorked * hrlyWage;
    }
  }

  public void payWorker(double hoursWorked) {
    double amount = calculatePay(hoursWorked);
    System.out.println(String.valueOf(hoursWorked) + "               " + String.valueOf(amount));
  }

}
