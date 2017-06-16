package timetowords;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Init hours and minutes
        int hours;
        int minutes;

        // Check that input is correct
        try {
            // First try to retrieve two integers
            hours = scan.nextInt();
            minutes = scan.nextInt();
            // Make sure 0 <= hours <= 12 and 0 <= minutes <= 60
            if(hours > 12 || hours < 1 || minutes > 60 || minutes < 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong Input");
            scan.close();
            return;
        } catch (NoSuchElementException e) {
            System.out.println("Wrong Input");
            scan.close();
            return;
        }

        // Now decide how to print the time. Raw Magic.
        if(minutes == 0) {
            System.out.println(intToText(hours) + " o'clock");
        }else if(minutes == 15) {
            System.out.println("quarter past " + intToText(hours));
        }else if(minutes < 30) {
            System.out.println(intToText(minutes) + " minute" + (minutes > 1 ? "s" : "") + " past " + intToText(hours));
        }else if(minutes == 30) {
            System.out.println("half past " + intToText(hours));
        }else if(minutes == 45) {
        	hours = (hours+1) % 12;
        	hours = hours == 0 ? 12 : hours;
            System.out.println("quarter to " + intToText(hours));
        }else if(minutes > 30) {
        	hours = (hours+1) % 12;
        	hours = hours == 0 ? 12 : hours;
            System.out.println(intToText(60-minutes) + " minute"+ (60-minutes > 1 ? "s" : "") +" to " + intToText(hours));
        }
        scan.close();

    }

    // This function converts an int < 70 to a text.
    // Example intToText(34) => thirty four
    public static String intToText(int hour) {
        String[] ones = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                                      "nine"};
        String[] teens = new String[] {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                                       "seventeen", "eighteen", "nineteen"};
        String[] tens = new String[] {"twenty", "thirty", "forty", "fifty", "sixty"};
        if(hour < 10) {
            return ones[hour];
        }else if(hour < 20) {
            return teens[hour-10];
        }else{
            int tIndex = (hour / 10) -2;
            int oIndex = hour - (hour / 10) * 10;
            return (tens[tIndex] + (oIndex > 0 ? " " + ones[oIndex] : ""));
        }
    }
}