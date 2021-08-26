package com.mx.HackerRankExercises;

import java.util.Scanner;

public class WeirdAndNotWeirdNumbers {

    public static final String NOT_WEIRD = "Not Weird";
    public static final String WEIRD = "Weird";
    public static final String SKIP_PATTERN = "(\r\n|[\n\r\u2028\u2029\u0085])?";
    public static final String NOT_A_NUMBER = "That's not a number!";

    /**
     * Print Weird if the number is weird; otherwise, print Not Weird.
     */
    public static void getScanInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        while (!scan.hasNextInt()) {
            System.out.println(NOT_A_NUMBER);
            scan.next();
        }
        int number = scan.nextInt();
        scan.skip(SKIP_PATTERN);
        String result;
        if ((number % 2 == 1) || (number >= 6 && number <= 20)) {
            result = WEIRD;
        } else if (number >= 2 && number <= 5){
            result = NOT_WEIRD;
        }
        else {
            result = NOT_WEIRD;
        }
        System.out.println(result);
    }
}
