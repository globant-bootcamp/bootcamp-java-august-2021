package hackerrankExercises;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class IntToString {

    public static Logger logger = LogManager.getLogger(IntToString.class.getName());

    static final String GOOD = "Good job";
    static final String WRONG = "Wrong answer.";
    static final String UNSUCCESSFUL = "Unsuccessful Termination!!";

    public static void main(String[] args) {
        DoNotTerminate.forbidExit();
        try {
            Scanner inputScanner = new Scanner(System.in);
            int inputNumber = inputScanner.nextInt();
            inputScanner.close();

            String inputNumberString = Integer.toString(inputNumber);

            if (inputNumber == Integer.parseInt(inputNumberString)) {
                logger.info(GOOD);
            } else {
                logger.info(WRONG);
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            logger.info(UNSUCCESSFUL);
        }
    }
}
