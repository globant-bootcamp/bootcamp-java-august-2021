package com.company;

import java.util.Scanner;

public class IfElse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int inputNumber = scanner.nextInt();

        if (inputNumber <= 100 && inputNumber >= 1) {
            if (inputNumber % 2 == 0) {
                if ((inputNumber >= 2 && inputNumber <= 5) || inputNumber > 20) {
                    System.out.println("Not Weird");
                } else {
                    System.out.println("Weird");
                }
            } else {
                System.out.println("Weird");
            }
        }

        scanner.close();
    }
}