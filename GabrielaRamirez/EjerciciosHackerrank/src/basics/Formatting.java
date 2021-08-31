package basics;
import java.util.Scanner;

public class Formatting {

    public static final String SPACE = "================================";
    public static final String STYLE = "%-15s%03d%n";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(SPACE);
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            System.out.printf(STYLE, s1, x);
        }
        System.out.println(SPACE);

    }
}
