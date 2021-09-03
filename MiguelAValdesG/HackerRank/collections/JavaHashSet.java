package collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);
    Set<String> stringPairs = new HashSet<>();
    final String SPACE = " ";

    int numberOfElements = readLineTerminal.nextInt();
    readLineTerminal.nextLine();

    String[] pairLeft = new String[numberOfElements];
    String[] pairRight = new String[numberOfElements];

    for (int index = 0; index < numberOfElements; index++) {
      pairLeft[index] = readLineTerminal.nextLine();
      pairRight[index] = readLineTerminal.nextLine();
    }

    for (int index = 0; index < numberOfElements; index++) {
      stringPairs.add(pairLeft[index] + SPACE + pairRight[index]);
      System.out.println(stringPairs.size());
    }
  }
}

// Challenge: https://www.hackerrank.com/challenges/java-hashset/problem
