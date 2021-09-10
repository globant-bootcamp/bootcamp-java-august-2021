package hackkerank.day3.ransomNote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagazineNoteCheck {

    public static final String NO = "No";
    public static final String YES = "Yes";

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Integer> magazineWordMap = new HashMap<>();
        for (String word : magazine) {

            if (magazineWordMap.containsKey(word)) {
                int count = magazineWordMap.get(word);
            } else {
                magazineWordMap.put(word, 1);
            }
        }

        for (String word : note) {

            if (magazineWordMap.containsKey(word)) {
                int count = magazineWordMap.get(word);
                if (count <= 0) {
                    System.out.println(NO);
                    return;
                }
                count--;
                magazineWordMap.put(word, count);
            } else if (!magazineWordMap.containsKey(word)) {
                System.out.println(NO);
                return;
            }
        }

        System.out.println(YES);

    }
}
