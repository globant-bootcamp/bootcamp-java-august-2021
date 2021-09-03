package bootcamp;

import java.util.Scanner;
import org.apache.log4j.Logger;

public class JavaIntoString {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    final Logger LOGGING = Logger.getLogger("bootcamp.JavaIntoString");
    final String SUCCESFUL_PARSING = "Good job";
    final String WRONG_ANSWER = "Wrong answer.";
    final String UNSUCCESFUL_PROCESS = "Unsuccessful Termination!!";
    
    try {
      int integer = scan.nextInt();
      scan.close();
      String string = String.valueOf(integer);
      if (integer == Integer.parseInt(string)) {
        LOGGING.debug(SUCCESFUL_PARSING);
      } else {
        LOGGING.debug(WRONG_ANSWER);
      }
    } catch (Exception exception) {
      LOGGING.error(UNSUCCESFUL_PROCESS);
    }
    scan.close();
  }
}
