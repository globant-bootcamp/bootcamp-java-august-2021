import java.util.Scanner;

public class JavaStdinAndStdoutII {

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);

    int readIntegerLineTerminal = readLineTerminal.nextInt();
    double readDoubleLineTerminal = readLineTerminal.nextDouble();
    readLineTerminal.nextLine();
    String readStringLineTerminal = readLineTerminal.nextLine();

    final String STRING_RESULT = "String: ".concat(readStringLineTerminal);
    final String DOUBLE_RESULT = "Double: " + readDoubleLineTerminal;
    final String INT_RESULT = "Int: " + readIntegerLineTerminal;

    System.out.println(STRING_RESULT);
    System.out.println(DOUBLE_RESULT);
    System.out.println(INT_RESULT);
  }

}
