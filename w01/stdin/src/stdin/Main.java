package stdin;


import java.util.Scanner;

// read  3 ints from sdtin and print each on a new line
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Trying to get an integer from System.in three times
        for(int i = 0; i < 3; i++) {
            System.out.println(scan.nextInt());
        }
        scan.close();
    }
}
