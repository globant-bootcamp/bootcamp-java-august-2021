package com.bootcamp.daythree.hackerrank.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {

    public static final String WHITE_SPACES = "\\s+$";
    public static final String SPACE = " ";
    public static final String WITHOUT_SPACE = "";
    public static final String ERROR = "ERROR!";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arrayNumber = scan.nextInt();
        scan.nextLine();
        List<String[]> auxList = new ArrayList<>();

        for (int iteratorNumbers = 0; iteratorNumbers < arrayNumber; iteratorNumbers++) {
            auxList.add(scan.nextLine().replaceAll(WHITE_SPACES, WITHOUT_SPACE).split(SPACE));
        }

        int queriesNumber = scan.nextInt();
        scan.nextLine();
        List<String[]> arrayQueries = new ArrayList<>();

        for (int iteratorQueries = 0; iteratorQueries < queriesNumber; iteratorQueries++) {
            arrayQueries.add(scan.nextLine().replaceAll(WHITE_SPACES, WITHOUT_SPACE).split(SPACE));
        }

        for (String[] query : arrayQueries) {
            checkQuery(query, arrayNumber, auxList);
        }
    }

    public static void checkQuery(String[] query, int arrayNumber, List<String[]> auxList) {
        if (Integer.parseInt(query[0]) > arrayNumber) {
            System.out.println(ERROR);
        } else {
            String[] temp = auxList.get(Integer.parseInt(query[0]) - 1);
            if (Integer.parseInt(query[1]) > temp.length - 1) {
                System.out.println(ERROR);
            } else {
                System.out.println(temp[Integer.parseInt(query[1])]);
            }
        }
    }
}
