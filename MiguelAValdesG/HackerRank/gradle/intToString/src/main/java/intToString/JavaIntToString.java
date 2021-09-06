package intToString;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class JavaIntToString {

  static Logger log = Logger.getLogger("Java Int to String");

  public static void main(String[] args){

    DoNotTerminate.forbidExit();

    try {
      Scanner readLineTerminal = new Scanner(System.in);
      int number = readLineTerminal.nextInt();
      readLineTerminal.close();

      String numberInString = Integer.toString(number);

      if (number == Integer.parseInt(numberInString)) {
        log.info("Good job");
      } else {
        log.error("Wrong answer.");
      }
    } catch (DoNotTerminate.ExitTrappedException e) {
      log.fatal("Exception: " + e);
    }
  }
}
