package javaHashset;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStringPairs = scanner.nextInt();
        String[] pairLeft = new String[numberOfStringPairs];
        String[] pairRight = new String[numberOfStringPairs];

        for (int i = 0; i < numberOfStringPairs; i++) {
            pairLeft[i] = scanner.next();
            pairRight[i] = scanner.next();
        }

        HashSet<String> hashSet = new HashSet<String>();
        
        for (int i = 0; i < numberOfStringPairs; i++) {
            hashSet.add(pairLeft[i] + " " + pairRight[i]);
            System.out.println(hashSet);
            System.out.println(hashSet.size());
        }

        scanner.close();
    }
}
