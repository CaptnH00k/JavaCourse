package whatsyourname;


import java.io.*;
import java.util.Scanner;


public class Main {

    /**
     * Read pre- and surname from stdin and print a greeting.
     */
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        // Getting pre & surname from Scanner
        String prename = scan.next();
        String surname = scan.next();
        // Writing it to screen
        System.out.println("Hello " + prename + "! You just delved into Java.\nYour full name: " + prename + " " + surname+ ".");
    }
}
