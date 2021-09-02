
package collection;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberLines = in.nextInt();
        List<List<Integer>> lineas = new ArrayList<>();
        for (int row = 0; row < numberLines; row++) {
            int columns = in.nextInt();
            List<Integer> linea = new ArrayList<>();
            for (int column = 0; column < columns; column++) {
                linea.add(in.nextInt()); 
            }
            lineas.add(linea);
        }
        int queries = in.nextInt();
        for (int numberQuery = 0; numberQuery < queries; numberQuery++) {
            int positionX = in.nextInt();
            int positionY = in.nextInt();
             List<Integer> linea = lineas.get(positionX-1);
            if (positionY <= linea.size()) {
                System.out.println(linea.get(positionY-1));
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
