package hackerrank.day3.ransom;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */
public class ExerciseRansom {

    public static final String YES = "Yes";
    public static final String NO = "No";

    public static void getWordsMagazine() {

        Scanner scanner = new Scanner(System.in);
        int magazineSize = scanner.nextInt();
        int noteSize = scanner.nextInt();

        scanner.nextLine();
        String[] magazine = scanner.nextLine().split(" ");
        String[] note = scanner.nextLine().split(" ");

        HashMap<String, Integer> frequentWord = new HashMap<>();

        for (int magazineIndex = 0; magazineIndex < magazineSize; magazineIndex++) {
            if (frequentWord.containsKey(magazine[magazineIndex])) {
                frequentWord.put(magazine[magazineIndex], frequentWord.get(magazine[magazineIndex]) + 1);
            } else {
                frequentWord.put(magazine[magazineIndex], 1);
            }
        }

        boolean result = false;

        for (int noteIndex = 0; noteIndex < noteSize; noteIndex++) {
            String noteWord = note[noteIndex];
            if (!frequentWord.containsKey(noteWord)) {
                result = true;
            } else {
                if (frequentWord.get(noteWord) > 1) {
                    frequentWord.put(noteWord, frequentWord.get(noteWord) - 1);
                } else {
                    frequentWord.remove(noteWord);
                }
            }
        }
        if (!result) {
            System.out.println(YES);
        } else {
            System.out.println(NO);
        }
    }
}
