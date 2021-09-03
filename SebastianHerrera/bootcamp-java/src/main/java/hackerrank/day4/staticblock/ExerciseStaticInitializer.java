package hackerrank.day4.staticblock;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 01/09/21
 */
@Log4j2
public class ExerciseStaticInitializer {

    public static final String ERROR_MESSAGE = "Breadth and height must be positive";
    static boolean flag = false;
    static int breadth, height;

    static {
        Scanner scanner = new Scanner(System.in);
        breadth = scanner.nextInt();
        height = scanner.nextInt();
        try {
            if (breadth <= 0 || height <= 0) {
                throw new Exception(ERROR_MESSAGE);
            }
            flag = true;
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }

    public static void getAreaParallelogram() {
        if (flag) {
            int area = breadth * height;
            log.debug("The area is: {}", area);
        }
    }

}
