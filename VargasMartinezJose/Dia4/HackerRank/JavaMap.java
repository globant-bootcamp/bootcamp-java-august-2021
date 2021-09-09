package bootcamp.collections.com;

import java.util.*;

class JavaMap {
    public static void main(String[] argh) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEntries = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, Integer> phoneBook = new HashMap<>();
        for (int index = 0; index < numberOfEntries; index++) {
            String name = scanner.nextLine();
            int phone = scanner.nextInt();
            phoneBook.put(name, phone);
            scanner.nextLine();
        }
        while (scanner.hasNext()) {
            String phoneBookValue = scanner.nextLine();
            if (phoneBook.containsKey(phoneBookValue)) {
                System.out.println(phoneBookValue + "=" + phoneBook.get(phoneBookValue));
            } else {
                System.out.println("Not found");
            }
        }
        scanner.close();
    }
}