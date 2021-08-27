package hackerrank.solutions;

import java.util.Scanner;

public class Third {

    public static void solving() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");

        for(int i = 0; i < 3; i++)
        {
            String formatedString=scanner.next();
            int formatedNumber=scanner.nextInt();

            System.out.printf("%-15s%03d%n", formatedString, formatedNumber);

        }

        System.out.println("================================");

    }
}
