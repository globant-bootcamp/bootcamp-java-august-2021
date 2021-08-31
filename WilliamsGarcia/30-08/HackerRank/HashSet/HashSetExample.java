package com.bootcamp.daythree.hackerrank.hashset;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetExample {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int inputNumber = scan.nextInt();
        String[] pair_left = new String[inputNumber];
        String[] pair_right = new String[inputNumber];

        for (int iteratorFill = 0; iteratorFill < inputNumber; iteratorFill++) {
            pair_left[iteratorFill] = scan.next();
            pair_right[iteratorFill] = scan.next();
        }

        scan.close();

        HashSet<String> merge = new HashSet(inputNumber);
        for (int iterator = 0; iterator < inputNumber; iterator++) {
            merge.add(pair_left[iterator] + " " + pair_right[iterator]);
            System.out.println(merge.size());
        }
    }
}
