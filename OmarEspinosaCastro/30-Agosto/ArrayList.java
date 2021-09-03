
package collection;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ArrayList {
    final static String ERROR = "ERROR!";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lineNumber = in.nextInt();
        List<List<Integer>> rowListList = new ArrayList<>();
        for (int row = 0; row < lineNumber; row++) {
            int columns = in.nextInt();
            List<Integer> lineList = new ArrayList<>();
            for (int column = 0; column < columns; column++) {
                lineList.add(in.nextInt()); 
            }
            rowListList.add(lineList);
        }
        int queryNumber = in.nextInt();
        for (int numberQuery = 0; numberQuery < queryNumber; numberQuery++) {
            int positionX = in.nextInt();
            int positionY = in.nextInt();
             List<Integer> line = rowListList.get(positionX-1);
            if (positionY <= line.size()) {
                System.out.println(line.get(positionY-1));
            } else {
                System.out.println(ERROR);
            }
        }
    }
}
