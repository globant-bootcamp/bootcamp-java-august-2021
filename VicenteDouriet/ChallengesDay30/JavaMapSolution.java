package com.king_arthur.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMapSolution {
    public static void main(String[] argh) {
        Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        scanner.nextLine();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < numLines; i++) {
            String name = scanner.nextLine();
            int phone = scanner.nextInt();
            map.put(name, phone);
            scanner.nextLine();
        }
        while (scanner.hasNext()) {
            String myString = scanner.nextLine();
            if (map.containsKey(myString) == true) {
                int number = map.get(myString);
                System.out.println(myString + "=" + number);
            } else {
                System.out.println("Not found");
            }
        }
    }
}
