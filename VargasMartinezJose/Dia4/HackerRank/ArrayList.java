package bootcamp.collections.com;

import java.io.*;
import java.util.*;

public class ArrayList{
    public static void main(String[] args) {
        ArrayList[] arrayLists = new ArrayList[20000];
        Scanner scanner = new Scanner(System.in);
        int numberOfline = scanner.nextInt();
        for (int index = 0; index < numberOfline; index++) {
            arrayLists[index] = new ArrayList();
            int sizeArrayList = scanner.nextInt();
            for (int j = 0; j < sizeArrayList; j++) {
                int valueOfArray = scanner.nextInt();
                arrayLists[index].add(valueOfArray);
            }
        }
        int totalOfQueries = scanner.nextInt();
        for (int index = 0; index < totalOfQueries; index++) {
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            try {
                System.out.println(arrayLists[row - 1].get(column - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
     }
}
