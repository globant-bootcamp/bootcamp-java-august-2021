package hackerrank.hashtablesransomnote;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Result {

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Integer> wordsFreqMagazineMap = createWordsFrequencyTable(magazine);
        Map<String, Integer> wordsFreqNoteMap = createWordsFrequencyTable(note);

        for(String word: note){
            int wordFreqInMagazine = (wordsFreqMagazineMap.get(word) == null)? 0 : wordsFreqMagazineMap.get(word);
            int wordFreqInNote = (wordsFreqNoteMap.get(word)== null)? 0 : wordsFreqNoteMap.get(word);

            if(wordFreqInMagazine < wordFreqInNote){
                System.out.println("No");
                return;
            }

        }

        System.out.println("Yes");

    }

    private static Map<String, Integer> createWordsFrequencyTable(List<String> words){
        Map<String, Integer> frequencyTableMap = new HashMap<>();
        for(String word: words){
            Integer frequency = frequencyTableMap.get(word);
            frequencyTableMap.put(word, (frequency == null)? 1 : frequency + 1);
        }
        return frequencyTableMap;
    }

}