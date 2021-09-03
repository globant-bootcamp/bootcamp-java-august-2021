package arrayList;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int lines = scan.nextInt();
        List<ArrayList<Integer>> queryArray = new ArrayList<ArrayList<Integer>>();

        for (int index = 0; index < lines; index++) {

            int numberOfIntegersInLine = scan.nextInt();
            ArrayList<Integer> integersArray = new ArrayList<Integer>();

            for (int number = 0; number < numberOfIntegersInLine; number++) {
                integersArray.add(scan.nextInt());
            }

            queryArray.add(integersArray);
        }

        int numberOfQueries = scan.nextInt();
        for (int queryIndex = 0; queryIndex < numberOfQueries; queryIndex++) {
            int queryX = scan.nextInt() - 1;
            int queryY = scan.nextInt() - 1;

            try {
                Integer queryFound = queryArray.get(queryX).get(queryY);
                System.out.println(queryFound);
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }

        scan.close();
    }
}
