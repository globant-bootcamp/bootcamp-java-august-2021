package com.king_arthur.hackerrank.printf;

import java.util.Scanner;

public class SolutionPrintf {
    public static final String STRT_END_INP_OUT = "================================";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(STRT_END_INP_OUT);
        final int NUM_ITERATIONS = 3;
        for (int currIteration = 0; i < NUM_ITERATIONS; currIteration++) {

            String formatString = scanner.next();
            int formatInt = scanner.nextInt();

            System.out.printf("%-15s%03d\n", formatString, formatInt);
        }

        System.out.println(STRT_END_INP_OUT);

    }
}