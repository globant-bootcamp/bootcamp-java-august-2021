package com.king_arthur_hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfLines = scanner.nextInt();
        ArrayList[] arrayLists = new ArrayList[20000];
        for (int i = 0; i < numOfLines; i++) {
            arrayLists[i] = new ArrayList();
            int numOfInts = scanner.nextInt();
            for (int j = 0; j < numOfInts; j++) {
                int value = scanner.nextInt();
                arrayLists[i].add(value);
            }
        }
        int numQueries = scanner.nextInt();
        for (int i = 0; i < numQueries; i++) {
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            try {
                System.out.println(arrayLists[row - 1].get(column - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }

    }
}
