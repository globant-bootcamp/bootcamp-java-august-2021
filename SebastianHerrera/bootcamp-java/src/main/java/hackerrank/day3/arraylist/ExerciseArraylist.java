package hackerrank.day3.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */
public class ExerciseArraylist {

    public static final String ERROR_MESSAGE = "ERROR!";

    public static void getArrayInfo() {

        Scanner scanner = new Scanner(System.in);

        int numberLines = scanner.nextInt();

        List<List> dynamicTable = new  ArrayList<>();

        for (int tableIndex = 0; tableIndex < numberLines; tableIndex++) {
            int arraySize = scanner.nextInt();
            List<Integer> arrayElements = new ArrayList<>();
            for (int lineIndex = 0; lineIndex < arraySize; lineIndex++) {
                arrayElements.add(scanner.nextInt());
            }
            dynamicTable.add(arrayElements);
        }

        int numberQueries = scanner.nextInt();
        for (int queryIndex = 0; queryIndex < numberQueries; queryIndex++) {
            int positionX = scanner.nextInt() - 1;
            int positionY = scanner.nextInt() - 1;

            try {
                System.out.println(dynamicTable.get(positionX).get(positionY));
            } catch (Exception e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }
}
