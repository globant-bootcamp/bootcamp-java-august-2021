package hackkerank.day1;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class StdinI {

    public static Logger logJava = Logger.getLogger(StdinI.class);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        logJava.info(a);
        logJava.info(b);
        logJava.info(c);
    }
}
