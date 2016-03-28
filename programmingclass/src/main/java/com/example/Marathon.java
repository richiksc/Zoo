package com.example;

/**
 * Created by Richik SC on 3/27/2016.
 * Assignment 3
 */
public class Marathon {
  public static void main(String[] args) {
    String peoples[] = {"Usain Bolt", "Fetty Wap", "Snoop Dogg", "Pi Patel"};
    double times[] = {1.2, 17.38, 4.20, 3.14};

    double fastestTime = 0;
    double secondBest = 0;
    for (int i = 0; i < times.length; i++) {

      double currTime = times[i];

      if(currTime < fastestTime || fastestTime == 0)
        fastestTime = currTime;

      if ((currTime > fastestTime && currTime < secondBest) || secondBest == 0)
        secondBest = currTime; // TODO: 3/28/2016 Figure out second best time.
    }

    System.out.println("fastestTime = " + fastestTime);
    System.out.println("secondBest = " + secondBest);
  }
}
