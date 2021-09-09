package hackkerank.day3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

    public static void main(String[] argh) {

        Scanner in = new Scanner(System.in);
        int numberOfEntries = in.nextInt();
        in.nextLine();
        Map<String, Integer> map = new HashMap<>(numberOfEntries);

        for (int i = 0; i < numberOfEntries; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            map.put(name, phone);
        }

        while (in.hasNext()) {
            String query = in.nextLine().trim();
            if (map.containsKey(query)) {
                System.out.println(query + "=" + map.get(query));
            } else {
                System.out.println("Not found");
            }
        }
    }
}

