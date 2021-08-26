package com.mx.HackerRankExercises;

import java.util.Scanner;

public class MiscValues {

    /**
     * Print String, Double and Int values.
     */
    public static void getScanInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int numInteger = scan.nextInt();
        System.out.print("Enter a double: ");
        double numDouble = scan.nextDouble();
        System.out.print("Enter a message: ");
        String messageString = " ";
        messageString = scan.nextLine();
        messageString += scan.nextLine();
        scan.close();

        System.out.println("String: " + messageString);
        System.out.println("Double: " + numDouble);
        System.out.println("Int: " + numInteger);
    }
}
