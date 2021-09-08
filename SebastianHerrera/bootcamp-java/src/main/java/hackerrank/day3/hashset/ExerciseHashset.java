package hackerrank.day3.hashset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */
public class ExerciseHashset {
    /**
     * Get names and verify duplicates
     */
    public static void getScanNames() {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] pairLeft = new String[testCases];
        String[] pairRight = new String[testCases];

        for (int index = 0; index < testCases; index++) {
            pairLeft[index] = scanner.next();
            pairRight[index] = scanner.next();
        }

        Set<String> pairs = new HashSet<>();
        System.out.println("Output: \n");
        for (int index = 0; index < testCases; index++) {
            pairs.add("(" + pairLeft[index] + ", " + pairRight[index] + ")");
            System.out.println(pairs.size());
        }

    }
}
