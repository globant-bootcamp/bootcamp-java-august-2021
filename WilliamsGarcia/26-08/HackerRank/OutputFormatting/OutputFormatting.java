package com.bootcamp.daytwo.hackerrank.outputformatting;

import java.util.Scanner;

public class OutputFormatting {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String input = scan.next();
            int auxInput = scan.nextInt();
            System.out.printf("%-15s%03d%n", input, auxInput);
        }
        System.out.println("================================");

    }
}
