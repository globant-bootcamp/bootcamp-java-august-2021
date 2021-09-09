package com.mycompany.javacollections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SolutionArrayList {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numQueries;
        System.out.println("Write the number of lines, then an Enter");
        int numColumns = scanner.nextInt();
        scanner.nextLine();
        List<List<Integer>> columns = new ArrayList(numColumns);
        for (int pointer = 0; pointer < numColumns; pointer++) {
            String row = scanner.nextLine();
            String[] values = row.split(" ");
            Integer numRows = Integer.valueOf(values[0]);
            List<Integer> rowValues = new ArrayList<>();
            for (int indexRows = 1; indexRows <= numRows; indexRows++) {
                rowValues.add(Integer.valueOf(values[indexRows]));                
            }
            columns.add(rowValues);
            System.out.println(rowValues);
        }
        
        numQueries = scanner.nextInt();
        scanner.nextLine();
        List<List<Integer>> queries = new ArrayList(numQueries);
        for (int pointer = 0; pointer < numQueries; pointer++) {
            String query = scanner.nextLine();
            String[] queryValues = query.split(" ");
            queries.add(Arrays.asList(Integer.valueOf(queryValues[0]) - 1, Integer.valueOf(queryValues[1]) - 1));
            System.out.println(queries);
        }
        
        Result.queryResult(columns, queries);
        scanner.close();
    }
}
