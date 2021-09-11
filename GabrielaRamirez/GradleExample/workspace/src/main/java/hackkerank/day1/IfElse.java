package hackkerank.day1;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class IfElse {

    public static Logger LOG_JAVA = Logger.getLogger(IfElse.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int number = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SCANNER.close();

        if (number%2==0 && 2<=number && number<=5){
            LOG_JAVA.info("Not Weird");
        }
        else if(number%2==0 & 2<=number & number<=5){
            LOG_JAVA.info("Not Weird");
        }
        else if (number%2==0 & 6 <= number & number<=20){
            LOG_JAVA.info("Weird");
        }
        else if(number%2==0 & 20<number){
            LOG_JAVA.info("Not Weird");
        }
        else if (number%2!=0){
            LOG_JAVA.info("Weird");
        }
    }
}
