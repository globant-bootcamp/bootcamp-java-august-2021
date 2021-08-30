import java.util.Scanner;

public class JavaOutputFormatting {

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);
    final int ELEMENTS_SIZE = 3;

    System.out.println("================================");
    for(int i = 0; i < ELEMENTS_SIZE; i++)
    {
      String readStringLineTerminal = readLineTerminal.next();
      int readIntLineTerminal = readLineTerminal.nextInt();
      System.out.printf("%-15s%03d%n", readStringLineTerminal, readIntLineTerminal);
    }
    System.out.println("================================");

  }
}
