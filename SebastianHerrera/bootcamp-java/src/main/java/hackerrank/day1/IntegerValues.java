package hackerrank.day1;

import java.util.Scanner;

public class IntegerValues {

    private static final int PRINT_SIZE = 3;

    /**
     * Print input integers
     */
    public static void getScanInfo() {
        Scanner scan = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.print("Enter an integer: ");
        for (int i = 0; i < PRINT_SIZE; i++) {
            if (i != 0) {
                System.out.print("Enter an integer: ");
            }
            stringBuilder.append(scan.nextInt()).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
