package Hackerrank.August31;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class JavaIntToString {
    static final Logger LOGGER = LogManager.getLogger(JavaIntToString.class);

    public static void solution(String[] args) {

        final String OK = "Good job";
        final String NOT_OK = "Wrong answer";
        Scanner scanInput = new Scanner(System.in);
        int integer = scanInput .nextInt();
        scanInput.close();

        String string = ""+integer;

        if (integer == Integer.parseInt(string)) {
            LOGGER.debug(OK);
        }
        else {
            LOGGER.debug(NOT_OK);
        }
    }
}
