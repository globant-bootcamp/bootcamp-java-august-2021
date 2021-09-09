package git;

import java.util.Scanner;

public class JavaIfElse {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int readIntegerLineTerminal = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    final String WEIRD = "Weird";
    final String NOT_WEIRD = "Not Weird";
    final String NUMBER_SIZE_VALIDATION = "The number have be between 1 and 100";

    if (readIntegerLineTerminal >= 1 && readIntegerLineTerminal <= 100) {
      if (readIntegerLineTerminal % 2 == 1 || (readIntegerLineTerminal >= 6 && readIntegerLineTerminal <= 20))
        System.out.println(WEIRD);
      else
        System.out.println(NOT_WEIRD);
    } else
      System.out.println(NUMBER_SIZE_VALIDATION);

    scanner.close();
  }
}
