package gradleproject.javainttostring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class JavaIntToString {

    private static final Logger logger = LoggerFactory.getLogger(JavaIntToString.class);

    public static void main(String[] args) {

        DoNotTerminate.forbidExit();

        try {
            Scanner scanner = new Scanner(System.in);
            int inputNumber = scanner .nextInt();
            scanner.close();

            String intAsString = String.valueOf(inputNumber);

            if (inputNumber == Integer.parseInt(intAsString)) {
                logger.info("Good job");
            } else {
                logger.info("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            logger.info("Unsuccessful Termination!!");
        }
    }

}
