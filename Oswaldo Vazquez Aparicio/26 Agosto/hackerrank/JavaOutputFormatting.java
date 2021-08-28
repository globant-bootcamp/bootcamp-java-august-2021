package hackerrank;

import java.util.Scanner;

public class JavaOutputFormatting {

    public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            String separatorLine = "================================"
            System.out.println(separatorLine);
            for(int i = 0;i < 3;i++){
                String word = sc.next();
                int number = sc.nextInt();
                System.out.printf("%-15s%03d%n", word, number);
            }
            System.out.println(separatorLine);

    }
}