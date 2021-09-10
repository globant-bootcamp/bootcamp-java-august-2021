package hackkerank.day2;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Formatting {

    public static Logger logJava = Logger.getLogger(Formatting.class);

    public static final String SPACE = "================================";
    public static final String STYLE = "%-15s%03d%n";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        logJava.info(SPACE);
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf(STYLE, s1, x);
        }
        logJava.info(SPACE);

    }
}
