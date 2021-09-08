package bootcamp.collections.com;

import java.io.*;
import java.util.*;
import java.text.*;

public class HashSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPairs = scanner.nextInt();
        String[] pairLeft = new String[numberOfPairs];
        String[] pairRight = new String[numberOfPairs];
        for (int index = 0; index < numberOfPairs; index++) {
            pairLeft[index] = scanner.next();
            pairRight[index] = scanner.next();
        }
        Set<String> stringSet = new HashSet<>();
        for (int index = 0; index < numberOfPairs; index++) {
            stringSet.add(pairLeft[index] + "," + pairRight[index]);
            System.out.println(stringSet.size());
        }
        Iterator<String> iteration = stringSet.iterator();
    }
}