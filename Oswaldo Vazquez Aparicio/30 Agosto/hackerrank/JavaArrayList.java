package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public JavaArrayList {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<List<Integer>> tableListList; 

    public static void main(String[] args) {

        int rowsNumber = scanner.nextInt();
        scanner.nextLine();

        tableListList = createTable(rowsNumber);

        int queriesNumber = scanner.nextInt();
        scanner.nextLine();

        executeQueries(queriesNumber);

        scanner.close();

    }

    private static List<List<Integer>> createTable(int rowsNumber) {
        List<List<Integer>> tableListList = new ArrayList<>(rowsNumber);
        for (int rowIndex = 0; rowIndex < rowsNumber; rowIndex++) {
            int numbersInRow = scanner.nextInt();
            List<Integer> row = createRow(numbersInRow);
            tableListList.add(row);
        }
        scanner.nextLine();
        return tableListList;
    }

    private static List<Integer> createRow(int numbersInRow) {
        List<Integer> row = new ArrayList<>(numbersInRow);
        for (int numberIndex = 0; numberIndex < numbersInRow; numberIndex++) {
            int number = scanner.nextInt();
            row.add(number);
        }
        return row;
    }

    private static void executeQueries(int queriesNumber) {
        for (int queryIndex = 0; queryIndex < queriesNumber; queryIndex++) {
            int lineNumber = scanner.nextInt();
            int position = scanner.nextInt();
            performQuery(lineNumber, position);
            scanner.nextLine();
        }
    }

    private static void performQuery(int lineNumber, int position) {
        String errorMessage = "ERROR!";
        int linesNumber = tableListList.size();

        if (lineNumber <= linesNumber) {

            List<Integer> line = tableListList.get(lineNumber - 1);
            if (position <= line.size()) {
                int numberResult = line.get(position - 1);
                System.out.println(numberResult);
            } else {
                System.out.println(errorMessage);
            }

        } else {
            System.out.println(errorMessage);
        }
    }

}