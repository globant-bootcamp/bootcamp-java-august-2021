package ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListResult {
    final static String EMPTY = "ERROR!";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfLines = in.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int row = 0; row < numberOfLines; row++) {
            int columns = in.nextInt();
            List<Integer> rowList = new ArrayList<>();
            for (int column = 0; column < columns; column++) {
                rowList.add(in.nextInt());
            }
            matrix.add(rowList);
        }

        int numberOfQueries = in.nextInt();

        for (int query = 0; query < numberOfQueries; query++) {
            int columnPosition = in.nextInt();
            int RowPosition = in.nextInt();
            List<Integer> resultRow = matrix.get(columnPosition-1);
            if (RowPosition <= resultRow.size()) {
                System.out.println(resultRow.get(RowPosition-1));
            } else {
                System.out.println(EMPTY);
            }
        }
    }
}
