package com.mycompany.hackerrank;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double d = scanner.nextDouble();
        scanner.nextLine(); //Reads the enter key. 
        String s = scanner.nextLine();
        
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + n);
    }
}