package hashTablesRansomNote;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Result {

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Integer> wordsFromMagazine = new HashMap<String, Integer>();

        for (String word : magazine) {
            if (wordsFromMagazine.containsKey(word))
                wordsFromMagazine.put(word, wordsFromMagazine.get(word) + 1);
            else
                wordsFromMagazine.put(word, 1);
        }

        for (String word : note) {
            if (wordsFromMagazine.containsKey(word)) {
                wordsFromMagazine.put(word, wordsFromMagazine.get(word) - 1);
                if (wordsFromMagazine.get(word) < 0) {
                    System.out.println("No");
                    return;
                }
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
