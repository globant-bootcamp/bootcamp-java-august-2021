package hackerrank.day2.exercise3;
/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 26/08/21
 */

import java.util.Scanner;

public class Exercise3 {

    public static final String PRINT_FORMAT = "================================";
    public static final String FORMAT_ODER = "%-15s%03d\n";

    /**
     * Get information from user and formatting
     */
    public static void getScanInfo() {
        Scanner sc = new Scanner(System.in);
        int[] arrayInteger = new int[3];
        String[] arrayString = new String[3];
        for (int i = 0; i < 3; i++) {
            arrayString[i] = sc.next();
            arrayInteger[i] = sc.nextInt();
        }
        System.out.println(PRINT_FORMAT);
        for (int i = 0; i < 3; i++) {
            System.out.printf(FORMAT_ODER, arrayString[i], arrayInteger[i]);
        }
        System.out.println(PRINT_FORMAT);

    }
}


