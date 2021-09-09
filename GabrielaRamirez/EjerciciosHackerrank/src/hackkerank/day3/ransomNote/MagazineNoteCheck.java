package hackkerank.day3.ransomNote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagazineNoteCheck {

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Integer> magazineWords = new HashMap<>();
        for (String word : magazine) {

            if (magazineWords.containsKey(word)) {
                int count = magazineWords.get(word);
            } else {
                magazineWords.put(word, 1);
            }
        }

        for (String word : note) {

            if (magazineWords.containsKey(word)) {
                int count = magazineWords.get(word);
                if (count <= 0) {
                    System.out.println("No");
                    return;
                }
                count--;
                magazineWords.put(word, count);
            } else if (!magazineWords.containsKey(word)) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");

    }
}
