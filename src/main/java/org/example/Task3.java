package org.example;

import java.util.*;

/**
 * Class for Task3 - Escape a labyrinth
 *
 * @author Apeksha Ambala
 * @since 1.0
 * @version 1.0
 */
public class Task3 {

  /**
   * This Method is the main method
   *
   * @param args - command line arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(":::Escape a labyrinth:::");
    System.out.println("Please enter a matrix:");
    String input = scanner.nextLine();
    scanner.close();

    int[][] inputArray = processInput(input);
    int result = getShortestPath(inputArray);
    System.out.println("result: " + result);
  }

  /**
   * This Method is used to find the shortest path
   *
   * @param inputArray - integer 2d array as input
   * @return integer value depicting the shortest path
   */
  private static int getShortestPath(int[][] inputArray) {
    int width = inputArray[0].length;
    int height = inputArray.length;
    // Find the shortest path from start to end of the input array
    int[][] shortStartToEnd = new int[height][width];
    // Setting the start index in height and width - top left (0,0)
    calculateShortestPath(0, 0, inputArray, shortStartToEnd);

    // Find the shortest path from end to start of the input array
    int[][] shortEndToStart = new int[height][width];
    // Setting the end index in height and width - bottom right (w-1,h-1)
    calculateShortestPath(height - 1, width - 1, inputArray, shortEndToStart);

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (shortStartToEnd[i][j] != -1 && shortEndToStart[i][j] != -1) {
          result = Math.min(shortStartToEnd[i][j] + shortEndToStart[i][j] - 1, result);
        }
      }
    }

    return result;
  }

  /**
   * This Method is used to calculate the shortest path
   *
   * @param height - height of the array of start/end index
   * @param width - width of the array of start/end index
   * @param inputArray - input array
   * @param newArray - resultant array
   */
  private static void calculateShortestPath(
      int height, int width, int[][] inputArray, int[][] newArray) {
    int inWidth = inputArray[0].length;
    int inHeight = inputArray.length;

    // Initialize new array with -1
    for (int i = 0; i < inHeight; i++) {
      for (int j = 0; j < inWidth; j++) {
        newArray[i][j] = -1;
      }
    }

    // Set the start/end index as 1
    newArray[height][width] = 1;

    // All possible directions to move
    // cardinal directions only as no diagonal moves are allowed
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    int level = 1;
    boolean updated = true;

    while (updated) {
      updated = false;

      for (int i = 0; i < inHeight; i++) {
        for (int j = 0; j < inWidth; j++) {
          if (newArray[i][j] == level) {
            for (int[] dir : directions) {
              int tmpHeight = i + dir[0];
              int tmpWidth = j + dir[1];

              if (tmpHeight >= 0
                  && tmpHeight < inHeight
                  && tmpWidth >= 0
                  && tmpWidth < inWidth
                  && newArray[tmpHeight][tmpWidth] == -1) {
                newArray[tmpHeight][tmpWidth] = level + 1;
                if (inputArray[tmpHeight][tmpWidth] != 1) {
                  updated = true;
                }
              }
            }
          }
        }
      }

      // For each level, increment
      level++;
    }
  }

  /**
   * This Method is used to process raw input string and return a 2d integer array
   *
   * @param input - raw input string
   * @return 2-d integer array
   */
  private static int[][] processInput(String input) {
    // Split using "]," as delimiter
    String[] row = input.split("],");
    int[][] inputArray = new int[row.length][];
    for (int i = 0; i < row.length; i++) {
      // Remove all square brackets
      String singleRow = row[i].replaceAll("[\\[\\]]", "");
      String[] col = singleRow.split(",");
      inputArray[i] = new int[col.length];
      for (int j = 0; j < col.length; j++) {
        inputArray[i][j] = Integer.parseInt(col[j].trim());
      }
    }
    return inputArray;
  }
}
