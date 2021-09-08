package bootcamp;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class JavaStaticInitialBlock {
    static final Logger LOGGER = Logger.getLogger("bootcamp.JavaStaticInitialBlock");
    static Scanner scan = new Scanner(System.in);
    static int numberOne = scan.nextInt();
    static int numberTwo = scan.nextInt();
    static boolean flag = true;
    static int breadth, height;
    static {
        try {
            if (numberOne <= 0 || numberTwo <= 0) {
                flag = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = breadth * height;
            LOGGER.debug(area);
        }
    }
} 
