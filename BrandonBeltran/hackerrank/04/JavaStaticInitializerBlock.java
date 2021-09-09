package bootcamp;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class JavaStaticInitializerBlock {

    private static final Logger logger = LogManager.getLogger(JavaStaticInitializerBlock.class);

    static Scanner input = new Scanner(System.in);
    static boolean positiveNumbersFlag = Boolean.TRUE;
    static int breadth = input.nextInt();
    static int height = input.nextInt();

    static{
        try{
            if(breadth <= 0 || height <= 0){
                positiveNumbersFlag = Boolean.FALSE;
                throw new Exception("Breadth and height must be positive");
            }
        }catch(Exception exception){
            logger.info(exception);
        }

    }

    public static void main(String[] args){
        if(positiveNumbersFlag){
            int area = breadth * height;
            logger.info(area);
        }

    }

}

