
package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ResultHashTables {
    
    static boolean checkMagazine(List<String> magazine, List<String> note) {
         Map<String, Integer> magazineWords = new HashMap<>();   
        for (String magazineString : magazine) {
            Integer wordCount = magazineWords.get(magazineString);
            if (wordCount == null) {
                magazineWords.put(magazineString, 1);
            } else {
                magazineWords.put(magazineString, wordCount + 1);
            }
        }
        for (String noteString : note) {
             Integer wordFound = magazineWords.get(noteString);
            if (wordFound == null || wordFound == 0) {
                return false;
            } else {
                magazineWords.put(noteString, wordFound - 1);
            }
        }
        return true;
    }
}
