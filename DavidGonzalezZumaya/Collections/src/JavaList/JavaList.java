package JavaList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int sizeOfList = in.nextInt();

        List<Integer> itemsList = new ArrayList<>();

        for (int index = 0; index < sizeOfList; index++) {
            int item = in.nextInt();
            itemsList.add(item);
        }

        int entryItems = in.nextInt();

        for (int indexOfEntryItems = 0; indexOfEntryItems < entryItems; indexOfEntryItems++) {
            String actionType = in.next();
            if (actionType.equals("Insert")) {
                int position = in.nextInt();
                int value = in.nextInt();
                itemsList.add(position, value);
            }else{
                int index = in.nextInt();
                itemsList.remove(index);
            }
        }

        for (Integer item : itemsList) {
            System.out.print(item + " ");
        }
    }
}
