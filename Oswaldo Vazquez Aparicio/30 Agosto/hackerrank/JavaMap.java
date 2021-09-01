package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

    private static final Scanner scanner = new Scanner(System.in);
    private static Map<String, Integer> phoneBook = new HashMap<>();

    public static void main(String[] args) {

        int numberContacts = scanner.nextInt();
        scanner.nextLine();

        createPhoneBook(numberContacts);

        while (hasNextQuery()) {
            String queryName = scanner.nextLine();
            String resultQuery = searchName(queryName);
            System.out.println(resultQuery);
        }

        scanner.close();

    }

    private static void createPhoneBook(int numContacts) {
        for (int contactIndex = 0; contactIndex < numContacts; contactIndex++) {
            addContact();
        }
    }

    private static void addContact() {
        String name = scanner.nextLine();
        Integer phoneNumber = scanner.nextInt();
        scanner.nextLine();
        phoneBook.put(name, phoneNumber);
    }

    private static boolean hasNextQuery(){
        return scanner.hasNext();
    }

    private static String searchName(String name) {
        return phoneBook.containsKey(name) ? String.format("%s=%d", name, phoneBook.get(name)) : "Not found";
    }
    
}
