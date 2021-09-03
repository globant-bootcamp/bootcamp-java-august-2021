package com.bootcamp.daythree.hackerrank.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample {

    public static final String NOT_FOUND = "Not found";
    public static final String SEPARATOR = " = ";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> contactMap = new HashMap<>();
        int inputNumber = scan.nextInt();
        scan.nextLine();

        for (int iterator = 0; iterator < inputNumber; iterator++) {
            String name = scan.nextLine();
            int phone = scan.nextInt();
            scan.nextLine();
            contactMap.put(name, phone);
        }
        
        while (scan.hasNext()) {
            String query = scan.nextLine();
            if (contactMap.containsKey(query)) {
                System.out.println(query + SEPARATOR + contactMap.get(query));
            } else {
                System.out.println(NOT_FOUND);
            }
        }
    }
}
