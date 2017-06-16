package integerprimitives;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Make sure we have a next long
        if(scan.hasNextLong()) {
            // get next long
            long stdin = scan.nextLong();
            System.out.println(stdin + " fits in:");
            // Check for all primitive number types
            fitsIn(Byte.MAX_VALUE, Byte.MIN_VALUE, stdin, "byte");
            fitsIn(Short.MAX_VALUE, Short.MIN_VALUE, stdin, "short");
            fitsIn(Integer.MAX_VALUE, Integer.MIN_VALUE, stdin, "int");
            fitsIn(Long.MAX_VALUE, Long.MIN_VALUE, stdin, "long");

        } else {
            // If not, tell the user
            System.out.println("\""+ scan.next() +"\" doesn't fit anywhere.");
        }
    }

    /**
     * If toFit is between maxValue and minValue, * $typenName will be print out
     * @param long maxValue
     * @param long minValue
     * @param long toFit
     * @param String typeName
     */
    public static void fitsIn(long maxValue, long minValue, long toFit, String typeName) {
        if(toFit <= maxValue && toFit >= minValue) {
            System.out.println("* "+typeName);
        }
    }
}

