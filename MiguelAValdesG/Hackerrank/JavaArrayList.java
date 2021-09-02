import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JavaArrayList {

  public static void main(String[] args) {
    Scanner readIntegerLineTerminal = new Scanner(System.in);
    List<List<Integer>> lines = new ArrayList<>();
    final int ONE = 1;
    final String ERROR = "ERROR!";


    int numberOfLines = readIntegerLineTerminal.nextInt();
    for (int indexLines = 0; indexLines < numberOfLines; indexLines++) {
      List<Integer> line = new ArrayList<>();
      int denotingNumber = readIntegerLineTerminal.nextInt();
      for (int indexLine = 0; indexLine < denotingNumber; indexLine++) {
        line.add(readIntegerLineTerminal.nextInt());
      }
      lines.add(line);
    }

    int numberOfQueries = readIntegerLineTerminal.nextInt();
    for (int indexLines = 0; indexLines < numberOfQueries; indexLines++) {
      int linesPosition = readIntegerLineTerminal.nextInt();
      int linePosition = readIntegerLineTerminal.nextInt();

      if (linePosition > lines.get(linesPosition - ONE).size() || linesPosition > lines.size()) {
        System.out.println(ERROR);
      } else {
        System.out.println(lines.get(linesPosition - ONE).get(linePosition - ONE));
      }
    }
  }
}

// Challenge: https://www.hackerrank.com/challenges/java-arraylist/problem
