package com.mycompany.javacollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SolutionJavaList {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String insert = "Insert";
        String delete = "Delete";
        int numValues = scanner.nextInt();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> values = new ArrayList<>(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        System.out.println(values);

        int numQueries;
        numQueries = scanner.nextInt();
        scanner.nextLine();
        for (int pointer = 0; pointer < numQueries; pointer++) {
            String query = scanner.nextLine();
            if (query.equals(insert)) {
                String[] valuesQuery = scanner.nextLine().split(" ");
                int position = Integer.parseInt(valuesQuery[0]);
                int valueToAdd = Integer.parseInt(valuesQuery[1]);
                Result.insertToList(values, position, valueToAdd);
            } else {
                int positionToDelete = scanner.nextInt();
                Result.deleteFromList(values, positionToDelete);
            }
        }
        System.out.println(values);
    }

}
