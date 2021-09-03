package bootcamp.dayfour.hackerrank.staticblock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class StaticBlock {

    static Scanner scan = new Scanner(System.in);
    static int inputNumberOne = scan.nextInt();
    static int inputNumberTwo = scan.nextInt();
    static final Logger LOGGER = LogManager.getLogger(StaticBlock.class);
    static final String ERROR = "java.lang.Exception: Breadth and height must be positive";
    static boolean flag = isValidInput();

    private static boolean isValidInput() {
        scan.close();
        boolean auxiliaryFlag;
        if (inputNumberOne > 0 && inputNumberTwo > 0) {
            auxiliaryFlag = true;
        } else {
            auxiliaryFlag = false;
            LOGGER.error(ERROR);
        }
        return auxiliaryFlag;
    }

    public static void main(String[] args) {
        if (flag) {
            int area = inputNumberOne * inputNumberTwo;
            LOGGER.info("The area is "+area);
        }

    }
}
