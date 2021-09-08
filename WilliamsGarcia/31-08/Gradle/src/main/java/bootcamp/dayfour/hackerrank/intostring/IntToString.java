package bootcamp.dayfour.hackerrank.intostring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class IntToString {

    static final String GOOD = "Good job";
    static final String WRONG = "Wrong answer.";
    static final String UNSUCCESSFUL = "Unsuccessful Termination!!";
    static final Logger LOGGER = LogManager.getLogger(IntToString.class);

    public static void main(String[] args) {
        DoNotTerminate.forbidExit();
        try {
            Scanner scan = new Scanner(System.in);
            int inputNumber = scan.nextInt();
            scan.close();

            String valueOfInputNumber = Integer.toString(inputNumber);

            if (inputNumber == Integer.parseInt(valueOfInputNumber)) {
                LOGGER.info(GOOD);
            } else {
                LOGGER.error(WRONG);
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            LOGGER.error(UNSUCCESSFUL);
        }
    }
}
