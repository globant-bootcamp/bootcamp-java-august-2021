package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public JavaArrayList {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<ArrayList<Integer>> table;

    public static void main(String[] args) {

        int rowsNumber = scanner.nextInt();
        scanner.nextLine();

        table = createTable(rowsNumber);

        int queriesNumber = scanner.nextInt();
        scanner.nextLine();

        executeQueries(queriesNumber);

        scanner.close();

    }

    private static ArrayList<ArrayList<Integer>> createTable(int rowsNumber) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<>(rowsNumber);
        for (int rowIndex = 0; rowIndex < rowsNumber; rowIndex++) {
            int numbersInRow = scanner.nextInt();
            ArrayList<Integer> row = createRow(numbersInRow);
            table.add(row);
        }
        scanner.nextLine();
        return table;
    }

    private static ArrayList<Integer> createRow(int numbersInRow) {
        ArrayList<Integer> row = new ArrayList<>(numbersInRow);
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
        int linesNumber = table.size();

        if (lineNumber <= linesNumber) {

            ArrayList<Integer> line = table.get(lineNumber - 1);
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