package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Class for Task2 - Advertising Bid Auction
 *
 * @author Apeksha Ambala
 * @since 1.0
 * @version 1.0
 */
public class Task2 {
  // Advertising Bid Auction

  /**
   * This Method is the main method
   *
   * @param args - command line arguments
   */
  public static void main(String[] args) {
    HashMap<Integer, Double> map;
    Scanner scanner = new Scanner(System.in);
    System.out.println(":::Advertising Bid Auction:::");
    System.out.println("Keep your file in src/main/resources/ folder.");
    System.out.println("Please enter a filename:");
    String input = scanner.nextLine();
    scanner.close();
    map = readFileAndProcess(input);
    getResults(map);
  }

  /**
   * This Method is used to process input hashmap and print the results for highest bidder with
   * payable value
   *
   * @param map - input hashmap of integer (bidder id) as key and double (price) as value
   */
  private static void getResults(HashMap<Integer, Double> map) {
    int maxId = 0;
    double maxVal = 0D;
    double secondMaxVal = 0D;

    boolean firstEntry = true;
    for (Map.Entry<Integer, Double> entry : map.entrySet()) {
      if (firstEntry) {
        firstEntry = false;
        maxId = entry.getKey();
        maxVal = entry.getValue();
      } else {
        double val = entry.getValue();
        if (maxVal < val) {
          secondMaxVal = maxVal;
          maxVal = val;
          maxId = entry.getKey();
        } else if (secondMaxVal < val) {
          secondMaxVal = val;
        }
      }
    }
    System.out.println(maxId + ", " + secondMaxVal);
  }

  /**
   * This Method is used to process raw input string and return a hashmap of integer and double
   *
   * @param input - raw input string
   * @return hashmap of integer as key and double as value
   */
  private static HashMap<Integer, Double> readFileAndProcess(String input) {
    HashMap<Integer, Double> map = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + input))) {
      while (br.ready()) {
        // Example: 1, 0.5
        String[] tmp = br.readLine().split(",");
        if (tmp.length == 2) {
          map.put(Integer.parseInt(tmp[0].trim()), Double.parseDouble(tmp[1].trim()));
        }
      }
    } catch (FileNotFoundException fileNotFoundException) {
      System.out.println(
          "Input file missing. Please keep the file in resources folder with filename 'File.csv'");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return map;
  }
}
