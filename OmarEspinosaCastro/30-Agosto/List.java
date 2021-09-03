
package collection;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class List {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int numberElements = in.nextInt();
        List<Integer> listList = new ArrayList<>();
        for (int i = 0; i < numberElements; i++) {
            int valueElement = in.nextInt();
            listList.add(valueElement);
        }
        int query = in.nextInt();
        for (int queryNumber = 0; queryNumber < query; queryNumber++) {
            String querie = in.next();
            if (querie.equals("Insert")) {
                int index = in.nextInt();
                int value = in.nextInt();
                listList.add(index, value);
            }else{
                int index = in.nextInt();
                listList.remove(index);
            }
        }
        for (Integer element : listList) {
            System.out.print(element + " ");
        }
    }
}
