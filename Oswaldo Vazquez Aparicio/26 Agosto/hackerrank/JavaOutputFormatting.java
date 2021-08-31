package hackerrank;

import java.util.Scanner;

public class JavaOutputFormatting {

    public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            String separatorLine = "================================"
            System.out.println(separatorLine);
            for(int lines = 0;lines < 3;lines++){
                String word = sc.next();
                int number = sc.nextInt();
                System.out.printf("%-15s%03d%n", word, number);
            }
            System.out.println(separatorLine);

    }
}