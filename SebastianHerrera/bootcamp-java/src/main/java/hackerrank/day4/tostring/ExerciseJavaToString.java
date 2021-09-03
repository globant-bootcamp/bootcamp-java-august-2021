package hackerrank.day4.tostring;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 01/09/21
 */
@Log4j2
public class ExerciseJavaToString {

    public static final String GOOD = "Good job";
    public static final String BAD = "Wrong answer";
    public static final String MESSAGE_ERROR = "Unsuccessful Termination!!";

    public static void getParseInteger() {
        DoNotTerminate.forbidExit();

        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            String parseInteger = Integer.toString(number);
            if (number == Integer.parseInt(parseInteger)) {
                log.info(GOOD);
            } else {
                log.info(BAD);
            }
        } catch (DoNotTerminate.ExitTrappedException exception) {
            log.error(MESSAGE_ERROR);
        }
    }

}
