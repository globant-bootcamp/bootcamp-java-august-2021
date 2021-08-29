package hackerrank.solutions;

import java.util.Scanner;

public class Third {

    public static void solving() {

        Scanner scanner = new Scanner(System.in);

        final String DECORATOR = "================================";
        System.out.println(DECORATOR);

        final int NUMBER_OF_ITERATIONS = 3;
        for (int currentIteration = 0; currentIteration < NUMBER_OF_ITERATIONS; currentIteration++) {

            String formattedString = scanner.next();
            int formattedNumber = scanner.nextInt();

            System.out.printf("%-15s%03d%n", formattedString, formattedNumber);

        }

        System.out.println(DECORATOR);

    }
}
