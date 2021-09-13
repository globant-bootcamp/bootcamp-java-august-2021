package javainttostring;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import java.util.Scanner;

public class JavaIntToString {

    static final String GOOD_JOB = "Good job.";
    static final String WRONG_ANSWER = "Wrong answer.";

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        DoNotTerminate.forbidExit();

        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            scanner.close();

            String numberToConvert = Integer.toString(number);

            if (number == Integer.parseInt(numberToConvert)) {
                logger.info(GOOD_JOB);
            } else {
                logger.error(WRONG_ANSWER);
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            logger.fatal(e.getMessage());
        }
    }
}
