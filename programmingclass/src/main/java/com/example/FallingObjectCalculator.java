package com.example;



public class FallingObjectCalculator {
  public static void main(String[] args) {
    if(args.length == 3) {
      FallingObjectCalculator calculator = new FallingObjectCalculator();
      try {
        double[] givens={ Double.parseDouble(args[0])
                          , Double.parseDouble(args[1])
                          , Double.parseDouble(args[2])
                        };

        System.out.println(calculator.calculatePosition(givens[0], givens[1], givens[2]));
      } catch (NumberFormatException e) {
        System.out.println("At least one of your arguments is not a double!\n" +
                            "What could it be? Look closer and you'll find out!");
        System.exit(1);
      } catch (Exception ex) {
        ex.printStackTrace();
      }


    } else {
      System.out.println("Please enter the three arguments: time, initial position, and initial " +
          "velocity.");
      System.exit(1);
    }
  }

  /**
   * Calculates the position of a falling object.
   * @param t The time from drop to get the distance at.
   * @param xi The initial position (distance from ground).
   * @param vi The initial velocity.
   */
  public double calculatePosition(double t, double xi, double vi) {
    return 0.5 * 9.81 * (t * t) + (vi * t) + xi;
  }
}
