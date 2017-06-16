package addtwoints;

import java.util.Scanner;

// read two ints from stdin, add them and print out the result.
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Get first & secondInt from stdin
        int firstInt = scan.nextInt();
        int secondInt = scan.nextInt();
        // Add them together and print them out
        System.out.println(firstInt + secondInt);
    }
}
