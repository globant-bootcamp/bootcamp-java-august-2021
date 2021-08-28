package hackerrank.solutions;

import java.util.Scanner;

public class Third {

    public static void solving() {

        Scanner scanner = new Scanner(System.in);
        int numOfIterations = 3;

        String decorator = "================================";
        System.out.println(decorator);

        for (int currentIteration = 0; currentIteration < numOfIterations; currentIteration++) {

            String formattedString = scanner.next();
            int formattedNumber = scanner.nextInt();

            System.out.printf("%-15s%03d%n", formattedString, formattedNumber);

        }

        System.out.println(decorator);

    }
}
