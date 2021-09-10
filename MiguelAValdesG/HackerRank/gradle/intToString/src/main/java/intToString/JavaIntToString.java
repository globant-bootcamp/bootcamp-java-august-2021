package intToString;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class JavaIntToString {

  static final String INT_TO_STRING = "Java Int to String";
  static final String GOOD_JOB = "Good job.";
  static final String WRONG_ANSWER = "Wrong answer.";
  static final String EXCEPTION = "Exception: ";

  static Logger log = Logger.getLogger(INT_TO_STRING);

  public static void main(String[] args) {

    DoNotTerminate.forbidExit();

    try {
      Scanner readLineTerminal = new Scanner(System.in);
      int number = readLineTerminal.nextInt();
      readLineTerminal.close();

      String numberInString = Integer.toString(number);

      if (number == Integer.parseInt(numberInString)) {
        log.info(GOOD_JOB);
      } else {
        log.error(WRONG_ANSWER);
      }
    } catch (DoNotTerminate.ExitTrappedException e) {
      log.fatal(EXCEPTION + e);
    }
  }
}
