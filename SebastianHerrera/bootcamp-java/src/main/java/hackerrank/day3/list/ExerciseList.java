package hackerrank.day3.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */
public class ExerciseList {

    public static final String INSERT = "Insert";
    public static final String DELETE = "Delete";

    public static void getListInfo() {
        Scanner scanner = new Scanner(System.in);
        int numElementsList = scanner.nextInt();
        List<Integer> dataList = new ArrayList<>();
        for (int index = 0; index < numElementsList; index++) {
            dataList.add(scanner.nextInt());
        }
        int numberQueries = scanner.nextInt();
        for (int index = 0; index < numberQueries; index++) {
            switch (scanner.next()) {
                case INSERT:
                    dataList.add(scanner.nextInt(), scanner.nextInt());
                    break;
                case DELETE:
                    dataList.remove(scanner.nextInt());
            }
        }
        for (Integer listEntry : dataList) {
            System.out.print(listEntry + " ");
        }
    }
}
