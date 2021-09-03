
package collection;

import java.util.Hashtable;
import java.util.List;

public class ResultHashTables {
    
    static boolean checkMagazine(List<String> magazine, List<String> note) {
         Hashtable<String, Integer> magazineWords = new Hashtable<>();   
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
