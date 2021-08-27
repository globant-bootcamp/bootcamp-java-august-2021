package com.mycompany.hackerrank;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputAsInt = scanner.nextLine();
        String inputAsDouble = scanner.nextLine(); 
        String inputTypeString = scanner.nextLine();
        int inputTypeInt = Integer.parseInt(inputAsInt);
        double inputTypeDouble = Double.parseDouble(inputAsDouble);
        
        System.out.println("String: " + inputTypeString);
        System.out.println("Double: " + inputTypeDouble);
        System.out.println("Int: " + inputTypeInt); 
    }
}