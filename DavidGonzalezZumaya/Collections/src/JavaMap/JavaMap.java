package JavaMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

    final static String NOT_FOUND = "Not found";

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> phoneDirectoryMap = new HashMap<>();

        int directorySize = in.nextInt();
        in.nextLine();

        for (int index = 0; index < directorySize; index++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneDirectoryMap.put(name, phone);
            in.nextLine();

        }

        while (in.hasNext()) {
            String searchName = in.nextLine();
            if (phoneDirectoryMap.containsKey(searchName)) {
                System.out.println(searchName + "=" + phoneDirectoryMap.get(searchName));
            } else {
                System.out.println(NOT_FOUND);
            }
        }
    }
}
