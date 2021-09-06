package com.mycompany.javacollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionJavaMap {

    public static void main(String[] args) throws IOException {
        int MIN_DIGITS = 9999999;
        int MAX_DIGITS = 99999999;
        Scanner scanner = new Scanner(System.in);
        int numContacts = scanner.nextInt();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> mapAgenda = new HashMap<>();
        for (int point = 0; point < numContacts; point++) {
            String name = bufferedReader.readLine().toLowerCase();
            int phoneNumber = Integer.valueOf(bufferedReader.readLine());
            if (phoneNumber < MIN_DIGITS || phoneNumber > MAX_DIGITS) {
                System.out.println("The phone number need to have 8 digits");
            }
            mapAgenda.put(name, phoneNumber);
        }
        System.out.println(mapAgenda);

        int numSearch = Integer.valueOf(bufferedReader.readLine());
        for (int point = 0; point < numSearch; point++) {
            String search = bufferedReader.readLine().toLowerCase();
            if (mapAgenda.containsKey(search)) {
                System.out.println(search + "=" + mapAgenda.get(search));
            } else {
                System.out.println("Not found");
            }
        }
        scanner.close();
        bufferedReader.close();
    }
}
