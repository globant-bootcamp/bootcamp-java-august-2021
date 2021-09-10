package hackkerank.day1;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class StdinII {

    public static Logger LOG_JAVA = Logger.getLogger(StdinI.class);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstEntry = scan.nextInt();
        int secondEntry = scan.nextInt();
        int thirdEntry = scan.nextInt();

        LOG_JAVA.info(firstEntry);
        LOG_JAVA.info(secondEntry);
        LOG_JAVA.info(thirdEntry);
    }
}
