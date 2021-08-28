package com.bootcamp.daytwo.hackerrank.outputformatting;

import java.util.Scanner;

public class OutputFormatting {

    public static final String SEPARATOR = "================================";
    public static final int CYCLE_NUMBER = 3;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println(SEPARATOR);
        for (int i = 0; i < CYCLE_NUMBER; i++) {
            String input = scan.next();
            int auxInput = scan.nextInt();
            System.out.printf("%-15s%03d%n", input, auxInput);
        }
        System.out.println(SEPARATOR);

    }
}
