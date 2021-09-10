package hackkerank.day2;

import org.apache.log4j.Logger;
import java.util.Scanner;

public class Formatting {

    public static Logger LOG_JAVA = Logger.getLogger(Formatting.class);

    public static final String SPACE = "================================";
    public static final String STYLE = "%-15s%03d%n";

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        LOG_JAVA.info(SPACE);

        for(int i = 0; i < 3; i++) {
            String name=scanner.next();
            int telephone=scanner.nextInt();
            System.out.printf(STYLE, name, telephone);
        }
        LOG_JAVA.info(SPACE);
    }
}
