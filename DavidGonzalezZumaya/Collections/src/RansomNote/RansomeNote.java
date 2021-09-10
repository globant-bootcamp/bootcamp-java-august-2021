package RansomNote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomeNote {

    final static String YES = "Yes";
    final static String NO = "No";;

    public static void checkMagazine(List<String> magazineList, List<String> noteList) {

        Map<String, Integer> magazineMap = createMapOfMagazine(magazineList);

        if (validateMessage(magazineMap, noteList)) {
            System.out.print(YES);
        } else {
            System.out.print(NO);
        }
    }

    public static Map<String, Integer> createMapOfMagazine(List<String> magazineList) {
        Map<String, Integer> magazineWordsMap = new HashMap<String, Integer>();

        for (String word : magazineList) {
            if (magazineWordsMap.containsKey(word))
                magazineWordsMap.put(word, magazineWordsMap.get(word) + 1);
            else
                magazineWordsMap.put(word, 1);
        }

        return magazineWordsMap;
    }

    public static boolean validateMessage(Map<String, Integer> magazineWordsMap, List<String> noteList) {

        for (String word : noteList) {
            if (magazineWordsMap.containsKey(word)) {
                magazineWordsMap.put(word, magazineWordsMap.get(word) - 1);
                if (magazineWordsMap.get(word) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
