package com.company;

import java.util.Scanner;

public class StdIntStdOutTwo {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int inputInt = scan.nextInt();
        double inputDouble = scan.nextDouble();
        String inputString = scan.next() + scan.nextLine();
        scan.close();

        System.out.println("String: " + inputString);
        System.out.println("Double: " + inputDouble);
        System.out.println("Int: " + inputInt);
    }
}