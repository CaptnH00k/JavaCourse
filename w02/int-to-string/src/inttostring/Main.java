package inttostring;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Make sure we have an int
    if(scan.hasNextInt()) {
      System.out.println("Found int: " + scan.nextInt());
    }else {
      // If not, tell the user
      System.out.println("No int");
    }
  }
}
