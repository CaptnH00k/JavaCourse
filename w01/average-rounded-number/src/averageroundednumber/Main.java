package averageroundednumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Get all floats
        float firstFloat = scan.nextFloat();
        float secondFloat = scan.nextFloat();
        float thirdFloat = scan.nextFloat();
        // add them together and divide by 3
        float averageFloats = (firstFloat + secondFloat + thirdFloat) / 3;
        // use String.format to round with 2 places after comma
        String averageRoundedNumber = String.format("%.2f", averageFloats);
        // print it
        System.out.println(averageRoundedNumber);
    }
}
