package bootcamp;

import java.util.Scanner;
public class JavaFormatting {
	public static void Main(String[] args) {
	String lines = ("================================");
        Scanner sc=new Scanner(System.in);
        
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s%03d\n", s1,x);
        }
        System.out.println(lines);

}
}
