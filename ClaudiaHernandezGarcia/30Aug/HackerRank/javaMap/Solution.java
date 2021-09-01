package javaMap;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] argh) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEntries = scanner.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < numberOfEntries; i++) {
            String name = scanner.nextLine();
            int phone = scanner.nextInt();
            scanner.nextLine();

            map.put(name, phone);
        }

        while (scanner.hasNext()) {
            String key = scanner.nextLine();

            if (map.containsKey(key)) {
                System.out.println(key + "=" + map.get(key));
            } else {
                System.out.println("Not found");
            }
        }

        scanner.close();
    }
}
