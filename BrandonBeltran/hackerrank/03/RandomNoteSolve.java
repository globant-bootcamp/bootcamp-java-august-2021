package bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomNoteSolve {

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Integer> magazineWordsMap = wordsToHashMap(magazine);
        Map<String, Integer> noteWordMap = wordsToHashMap(note);

        String doable = "Yes";

        for(String word: noteWordMap.keySet()){
            if(magazineWordsMap.containsKey((word)) && magazineWordsMap.get(word) >= noteWordMap.get(word)){
                magazineWordsMap.put(word, magazineWordsMap.get(word)-noteWordMap.get(word));
            }else{
                doable = "No";
                break;
            }
        }

        System.out.println(doable);
    }

    public static Map<String, Integer> wordsToHashMap(List<String> wordsList){
        Map<String, Integer> convertedList = new HashMap<>();
        for(String word: wordsList){
            if(convertedList.containsKey(word)){
                convertedList.replace(word, convertedList.get(word)+1);
            }else{
                convertedList.put(word, 1);
            }
        }
        return convertedList;
    }


}
