package hackerrank.hashtableransomnote;

import java.util.HashMap;
import java.util.List;

class Result {

    public static void checkMagazine(List<String> magazine, List<String> note) {

        HashMap<String, Integer> wordsFreqMagazine = createWordsFrequencyTable(magazine);
        HashMap<String, Integer> wordsFreqNote = createWordsFrequencyTable(note);

        for(String word: note){
            int wordFreqInMagazine = (wordsFreqMagazine.get(word) == null)? 0 : wordsFreqMagazine.get(word);
            int wordFreqInNote = (wordsFreqNote.get(word)== null)? 0 : wordsFreqNote.get(word);

            if(wordFreqInMagazine < wordFreqInNote){
                System.out.println("No");
                return;
            }

        }

        System.out.println("Yes");

    }

    private static HashMap<String, Integer> createWordsFrequencyTable(List<String> words){
        HashMap<String, Integer> frequencyTable = new HashMap<>();
        for(String word: words){
            Integer frequency = frequencyTable.get(word);
            frequencyTable.put(word, (frequency == null)? 1 : frequency + 1);
        }
        return frequencyTable;
    }

}