package bootcamp;

import java.util.HashSet;
import java.util.Scanner;

/* This solution is the one that I submitted to Hackerrank. I just
*  renamed the variables to a more readable state */

public class JavaHashsetHackerrank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        String [] pairLeft = new String[queries];
        String [] pairRight = new String[queries];

        for (int index = 0; index < queries; index++) {
            pairLeft[index] = scanner.next();
            pairRight[index] = scanner.next();
        }

        HashSet<String> pairs = new HashSet<>();
        for(int iterator = 0; iterator < queries; iterator++){
            pairs.add(pairLeft[iterator] + " " + pairRight[iterator]);
            System.out.println(pairs.size());
        }

    }
}