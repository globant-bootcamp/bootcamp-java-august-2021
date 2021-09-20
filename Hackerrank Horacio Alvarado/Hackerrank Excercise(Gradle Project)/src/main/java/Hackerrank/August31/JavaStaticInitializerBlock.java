package Hackerrank.August31;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class JavaStaticInitializerBlock {
    public static final Logger LOGGER = LogManager.getLogger(JavaStaticInitializerBlock.class);
    static int breadth;
    static int height;
    static boolean flag;
    static final String ERROR = "java.lang.Exception: Breadth and height must be positive";

    static {
        Scanner scanInput = new Scanner(System.in);
        breadth = scanInput.nextInt();
        height = scanInput.nextInt();
        if (breadth > 0 && height > 0) {
            flag = true;
        } else {
            LOGGER.debug(ERROR);
            flag = false;
        }
    }

    public static void solution(String[] args){
        if(flag){
            int area= breadth * height;
            LOGGER.debug(area);
        }
    }
}
