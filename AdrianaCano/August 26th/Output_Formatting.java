package com.mycompany.hackerrank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int NUM_ITERATIONS = 3;
        int MAX_STRING_LENGTH = 10;
        int MAX_NUM = 1000;

        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        for (int pointer = 0; pointer < NUM_ITERATIONS; pointer++) {
            String word = scanner.next();
            int number = scanner.nextInt();
            if (word.length() <= MAX_STRING_LENGTH && number < MAX_NUM) {
                System.out.printf("%-15s%03d%n", word, number);
            } else {
                System.out.println("String length or digit number exceeded");
            }
        }
        System.out.println("================================");
    }
}