package challenges.two;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

            Scanner scan=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String text=scan.next();
                int number=scan.nextInt();
                System.out.printf("%-15s%03d\n", text, number);
                
            }
            System.out.println("================================");

    }
}



