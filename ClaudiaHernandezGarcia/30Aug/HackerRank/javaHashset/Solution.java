package javaHashset;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStringPairs = scanner.nextInt();
        String[] pair_left = new String[numberOfStringPairs];
        String[] pair_right = new String[numberOfStringPairs];

        for (int i = 0; i < numberOfStringPairs; i++) {
            pair_left[i] = scanner.next();
            pair_right[i] = scanner.next();
        }

        HashSet<String> hashSet = new HashSet<String>();
        
        for (int i = 0; i < numberOfStringPairs; i++) {
            hashSet.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(hashSet);
            System.out.println(hashSet.size());
        }

        scanner.close();
    }
}
