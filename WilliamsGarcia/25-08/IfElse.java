package com.company;

import java.util.Scanner;

public class IfElse {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String WEIRD = "Weird";
    public static final String NOT_WEIRD = "Weird";

    public static void main(String[] args) {

        int inputNumber = SCANNER.nextInt();

        if (inputNumber <= 100 && inputNumber >= 1) {
            if (inputNumber % 2 == 0) {
                if ((inputNumber >= 2 && inputNumber <= 5) || inputNumber > 20) {
                    System.out.println(NOT_WEIRD);
                } else {
                    System.out.println(WEIRD);
                }
            } else {
                System.out.println(WEIRD);
            }
        }

        SCANNER.close();
    }
}