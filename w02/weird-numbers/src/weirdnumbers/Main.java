package weirdnumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stdin = scan.nextInt();
        boolean isWeird = false;

        if((stdin % 2) != 0) {
            // is odd
            isWeird = true;
        } else if(stdin >= 6 && stdin <= 20) {
            isWeird = true;
        } else if(stdin < 0) {
            isWeird = true;
        }

        System.out.println(isWeird ? "Weird" : "Not Weird");
    }
}
