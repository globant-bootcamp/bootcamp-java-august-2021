package com.king_arthur.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaListSolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numElements = scanner.nextInt();
        List<Integer> list = new ArrayList();
        for (int i = 0; i < numElements; i++) {
            list.add(scanner.nextInt());
        }

        int numQueries = scanner.nextInt();

        for (int i = 0; i < numQueries; i++) {
            String query = scanner.next();
            int indexInsert = scanner.nextInt();
            if (query.equals("Insert")) {
                int indexDelete = scanner.nextInt();
                list.add(indexInsert, indexDelete);
            } else {
                list.remove(indexInsert);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
