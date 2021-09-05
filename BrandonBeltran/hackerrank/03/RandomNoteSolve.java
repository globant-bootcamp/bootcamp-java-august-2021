package bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomNoteSolve {

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Integer> magazineWords = wordsToHashMap(magazine);
        Map<String, Integer> noteWords = wordsToHashMap(note);

        String doable = "Yes";

        for(String word: noteWords.keySet()){
            if(magazineWords.containsKey((word)) && magazineWords.get(word) >= noteWords.get(word)){
                magazineWords.put(word, magazineWords.get(word)-noteWords.get(word));
            }else{
                doable = "No";
                break;
            }
        }

        System.out.println(doable);
    }

    public static HashMap<String, Integer> wordsToHashMap(List<String> wordsList){
        HashMap<String, Integer> convertedList = new HashMap<>();
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
