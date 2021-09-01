package com.bootcamp.daythree.hackerrank.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExample {

    public static final String CASE_INSERT = "Insert";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int inputNumber = scan.nextInt();
        List<Integer> numberList = new ArrayList<>();

        for (int iteratorFill = 0; iteratorFill < inputNumber; iteratorFill++) {
            numberList.add(scan.nextInt());
        }

        int numberQ = scan.nextInt();

        for (int iterator = 0; iterator < numberQ; iterator++) {
            if (scan.next().equals(CASE_INSERT)) {
                int index = scan.nextInt();
                int value = scan.nextInt();
                numberList.add(index, value);
            } else {
                numberList.remove(scan.nextInt());
            }
        }        
        scan.close();

        for (Integer number : numberList) {
            System.out.print(number + " ");
        }
    }
}