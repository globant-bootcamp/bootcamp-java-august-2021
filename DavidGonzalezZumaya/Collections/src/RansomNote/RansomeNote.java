package RansomNote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomeNote {

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Integer> magazineMap = createMapOfMagazine(magazine);

        if(validateMessage(magazineMap, note)){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }

    public static Map<String, Integer> createMapOfMagazine(List<String> magazine ){
        Map<String, Integer> MagazineWords = new HashMap<String, Integer>();

        for (String word : magazine) {
            if (MagazineWords.containsKey(word))
                MagazineWords.put(word, MagazineWords.get(word) + 1);
            else
                MagazineWords.put(word, 1);
        }

        return MagazineWords;
    }

    public static boolean validateMessage(Map<String, Integer> MagazineWords, List<String> note){

        for (String word : note) {
            if (MagazineWords.containsKey(word)) {
                MagazineWords.put(word, MagazineWords.get(word) - 1);
                if (MagazineWords.get(word) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
