package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for Task1 - Efficient Integer Conversion
 *
 * @author Apeksha Ambala
 * @since 1.0
 * @version 1.0
 */
public class Task1 {
  // Efficient Integer Conversion
  // operations:
  // 1. Add One
  // 2. Remove One
  // 3. Divide by 2 (only if the current amount is even)

  /**
   * This Method is the main method
   *
   * @param args - command line arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      System.out.println(":::Efficient Integer Conversion:::");
      System.out.println("Please enter an integer:");
      int input = scanner.nextInt();
      int count = checkCountToConvert(input);
      System.out.println("Number of steps executed: " + count);

    } catch (InputMismatchException inputMismatchException) {
      System.out.println("Your input is not an integer. Exiting.");
      scanner.close();
    } catch (Exception e) {
      System.out.println("Exception occurred. " + e.getMessage());
    }
  }

  /**
   * This Method is used to process raw input and return an integer with value showing number of
   * steps to convert the input
   *
   * @param input - raw input number
   * @return integer as number of steps to convert the value
   */
  private static int checkCountToConvert(int input) {
    int count = 0;

    if (input != 1) {
      while (input > 1) {
        // Check if number is even
        if (input % 2 == 0) {
          // 3. Divide by 2 (only if the current amount is even)
          input = input / 2;
        } else if (input == 3) {
          // 2. Remove One, if not specified it goes to add 1, then result changes to 3 steps
          // instead of 2
          input = input - 1;
        } else if (input % 4 == 1) {
          // 2. Remove One
          input = input - 1;
        } else {
          // 1. Add One
          input = input + 1;
        }
        count++;
      }
    }

    return count;
  }
}
