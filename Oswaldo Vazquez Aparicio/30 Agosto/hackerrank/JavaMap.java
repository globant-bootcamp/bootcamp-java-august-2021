package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class JavaMap {

    private static final Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Integer> phoneBook;

    public static void main(String[] argh) {

        int numberContacts = scanner.nextInt();
        scanner.nextLine();

        phoneBook = createPhoneBook(numberContacts);

        while (hasNextQuery()) {
            String queryName = scanner.nextLine();
            String resultQuery = searchName(queryName);
            System.out.println(resultQuery);
        }

        scanner.close();

    }

    private static HashMap<String, Integer> createPhoneBook(int numContacts) {
        HashMap<String, Integer> phoneBook = new HashMap<>();
        for (int contactIndex = 0; contactIndex < numContacts; contactIndex++) {
            addContact();
        }
        return phoneBook;
    }

    private static boolean hasNextQuery(){
        return scanner.hasNext();
    }

    private static String searchName(String name) {
        return phoneBook.containsKey(name) ? String.format("%s=%d", name, phoneBook.get(name)) : "Not found";
    }

    private static void addContact() {
        String name = scanner.nextLine();
        Integer phoneNumber = scanner.nextInt();
        phoneBook.put(name, phoneNumber);
    }
}
