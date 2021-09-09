package gradleproject.javastaticinitializerblock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class JavaStaticInitializerBlock {

    private static final Logger logger = LoggerFactory.getLogger(JavaStaticInitializerBlock.class);

    private static final Integer breadth;
    private static final Integer height;
    private static final boolean flag;

    static {
        Scanner scan = new Scanner(System.in);
        breadth = scan.nextInt();
        height = scan.nextInt();
        flag = (breadth > 0 && height > 0);
        scan.close();
    }

    public static void main(String[] args) {
        if(flag){
            Integer area = breadth * height;
            logger.info("{}", area);
        }else{
            logger.info("java.lang.Exception: Breadth and height must be positive");
        }
    }

}
