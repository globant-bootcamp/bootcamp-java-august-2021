package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);
    Map<String, Integer> phoneBook = new HashMap<>();
    final String NOT_FOUND = "Not found";
    final String EQUALS_TO = "=";

    int numberOfElements = readLineTerminal.nextInt();
    readLineTerminal.nextLine();

    for (int index = 0; index < numberOfElements; index++) {
      String name = readLineTerminal.nextLine();
      int phoneNumber = readLineTerminal.nextInt();
      phoneBook.put(name, phoneNumber);
      readLineTerminal.nextLine();
    }

    while(readLineTerminal.hasNext()) {
      String nameToCheck = readLineTerminal.nextLine();
      if (phoneBook.containsKey(nameToCheck)) {
        System.out.println(nameToCheck + EQUALS_TO + phoneBook.get(nameToCheck));
      } else
        System.out.println(NOT_FOUND);
    }
  }
}

// Challenge: https://www.hackerrank.com/challenges/phone-book/problem
