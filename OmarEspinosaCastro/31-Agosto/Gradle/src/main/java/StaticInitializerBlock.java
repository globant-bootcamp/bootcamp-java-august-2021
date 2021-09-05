import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class StaticInitializerBlock {

    public static Logger logger = LogManager.getLogger(StaticInitializerBlock.class.getName());

    static Scanner input = new Scanner(System.in);
    static int inputNumberBase = input.nextInt();
    static int inputNumberHeight = input.nextInt();
    static final String EXCEPTION = "java.lang.Exception: Breadth and height must be positive";
    static boolean flag = true;
    static {
            if(inputNumberBase <= 0 || inputNumberHeight <= 0){
                flag = false;
            }
    }
    public static void main(String[] args){
        if(flag){
            int area=inputNumberBase*inputNumberHeight;
            logger.info(area);
        }else {
            logger.info(EXCEPTION);
        }
    }
}
