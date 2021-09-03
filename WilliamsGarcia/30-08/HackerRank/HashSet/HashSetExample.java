package com.bootcamp.daythree.hackerrank.hashset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputNumber = scan.nextInt();
        String[] pairLeft = new String[inputNumber];
        String[] pairRight = new String[inputNumber];

        for (int iteratorFill = 0; iteratorFill < inputNumber; iteratorFill++) {
            pairLeft[iteratorFill] = scan.next();
            pairRight[iteratorFill] = scan.next();
        }

        scan.close();

        Set<String> mergeSet = new HashSet<>();
        for (int iterator = 0; iterator < inputNumber; iterator++) {
            mergeSet.add(pairLeft[iterator] + " " + pairRight[iterator]);
            System.out.println(mergeSet.size());
        }
    }
}