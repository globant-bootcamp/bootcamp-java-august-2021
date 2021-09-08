package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class JavaList {

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);
    int numberOfElementsInList = readLineTerminal.nextInt();
    final String ERROR = "ERROR!";
    final String SPACE = " ";
    StringBuilder response = new StringBuilder();
    List<Integer> list = new LinkedList<>();

    for (int indexList = 0; indexList < numberOfElementsInList; indexList++) {
      list.add(readLineTerminal.nextInt());
    }

    int numberOfQueries = readLineTerminal.nextInt();
    readLineTerminal.nextLine();

    for (int indexQueries = 0; indexQueries < numberOfQueries; indexQueries++) {
      String toDo = readLineTerminal.nextLine();
      if (toDo.equals("Insert")) {
        int index = readLineTerminal.nextInt();
        int value = readLineTerminal.nextInt();
        list.add(index, value);
      } else if (toDo.equals("Delete")) {
        list.remove(readLineTerminal.nextInt());
      } else {
        System.out.println(ERROR);
      }
      readLineTerminal.nextLine();
    }

    for (Integer number : list) {
      response.append(number.toString()).append(SPACE);
    }

    System.out.println(response);
  }
}

// Challenge: https://www.hackerrank.com/challenges/java-list/problem
