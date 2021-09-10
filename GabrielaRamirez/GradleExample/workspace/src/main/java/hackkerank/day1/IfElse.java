package hackkerank.day1;
import challenge.Icecream;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class IfElse {

    public static Logger logJava = Logger.getLogger(IfElse.class);

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        if (N%2==0 & 2<=N & N<=5){
            logJava.info("Not Weird");
        }
        else if(N%2==0 & 2<=N & N<=5){
            logJava.info("Not Weird");
        }
        else if (N%2==0 & 6 <= N & N<=20){
            logJava.info("Weird");
        }
        else if(N%2==0 & 20<N){
            logJava.info("Not Weird");
        }
        else if (N%2!=0){
            logJava.info("Weird");
        }
    }
}
