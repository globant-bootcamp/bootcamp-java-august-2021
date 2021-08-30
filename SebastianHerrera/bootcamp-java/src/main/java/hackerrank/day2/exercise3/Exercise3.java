package hackerrank.day2.exercise3;
/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 26/08/21
 */

import java.util.Scanner;

public class Exercise3 {

    public static final String SEPARATOR = "================================";
    public static final String FORMATTER = "%-15s%03d\n";

    /**
     * Get information from user and formatting
     */
    public static void getScanInfo() {
        Scanner scanner = new Scanner(System.in);
        int[] arrayInteger = new int[3];
        String[] arrayString = new String[3];
        for (int index = 0; index < 3; index++) {
            arrayString[index] = scanner.next();
            arrayInteger[index] = scanner.nextInt();
        }
        System.out.println(SEPARATOR);
        for (int index = 0; index < 3; index++) {
            System.out.printf(FORMATTER, arrayString[index], arrayInteger[index]);
        }
        System.out.println(SEPARATOR);

    }
}


