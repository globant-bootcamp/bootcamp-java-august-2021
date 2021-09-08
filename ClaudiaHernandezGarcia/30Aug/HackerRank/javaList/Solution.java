package javaList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfElements = scan.nextInt();
        List<Integer> list = new ArrayList<Integer>();  

        for (int itemNumber = 0; itemNumber < numberOfElements; itemNumber++) {
            list.add(scan.nextInt());  
        }

        int numberOfQueries = scan.nextInt();
        for (int queryNumber = 0; queryNumber < numberOfQueries; queryNumber++) {
            String typeOfQuery = scan.next();
            int queryPosition = scan.nextInt();

            switch (typeOfQuery) {
                case "Insert":
                    int value = scan.nextInt();
                    list.add(queryPosition, value); 
                    break;
                case "Delete":
                    list.remove(queryPosition);
                    break;
            }
        }

        String result = "";
        for (Integer integer : list) {
            result += integer.toString() + " ";
        }

        System.out.println(result);
    }
}
