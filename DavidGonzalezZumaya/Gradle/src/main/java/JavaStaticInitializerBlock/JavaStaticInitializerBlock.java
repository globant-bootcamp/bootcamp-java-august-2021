package JavaStaticInitializerBlock;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class JavaStaticInitializerBlock {

    static final String EXCEPTION_MESSAGE = "java.lang.Exception: Breadth and height must be positive";
    static final String LOGGER_MESSAGE = "Static Initializer Log";

    private static final Logger logger = Logger.getLogger(LOGGER_MESSAGE);
    static Boolean flag = true;
    static Scanner scanner = new Scanner(System.in);
    static int breadth = scanner.nextInt();
    static int height = scanner.nextInt();

    static {
        try {
            if (breadth <= 0 || height <= 0) {
                flag = false;
                throw new Exception(EXCEPTION_MESSAGE);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    public static void main(String[] args) {
        if (flag) {
            int area = breadth * height;
            logger.info(area);
        }
    }

}
