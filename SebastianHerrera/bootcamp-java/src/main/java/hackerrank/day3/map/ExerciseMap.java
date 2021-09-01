package hackerrank.day3.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */
public class ExerciseMap {

    public static void getScanDirectory() {
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner data = new Scanner(System.in);
        int testCases = data.nextInt();
        data.nextLine();
        for (int index = 0; index < testCases; index++) {
            String name = data.nextLine();
            int phone = data.nextInt();
            phoneBook.put(name, phone);
            data.nextLine();
        }

        while (data.hasNext()) {
            String nameToFind = data.nextLine();
            Integer phone = phoneBook.get(nameToFind);
            System.out.println(phoneBook.containsKey(nameToFind) ? nameToFind + "=" +
                    phone : "Not found");
        }
    }
}
