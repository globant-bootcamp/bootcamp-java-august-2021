package collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultHashTableRansom {
	public static void checkMagazine(List<String> magazine, List<String> note) {

		String valid = "Yes";
		Map<String, Integer> wordsOfMagazine = wordsToHashMap(magazine);
		Map<String, Integer> wordsOfNote = wordsToHashMap(note);

		for (String word : wordsOfNote.keySet()) {
			if (wordsOfMagazine.containsKey((word)) && wordsOfMagazine.get(word) >= wordsOfNote.get(word)) {
				wordsOfMagazine.put(word, wordsOfMagazine.get(word) - wordsOfNote.get(word));
			} else {
				valid = "No";
				break;
			}
		}

		System.out.println(valid);
	}

	public static HashMap<String, Integer> wordsToHashMap(List<String> wordsList) {
		HashMap<String, Integer> myMapConverted = new HashMap<String, Integer>();
		for (String word : wordsList) {
			if (myMapConverted.containsKey(word)) {
				myMapConverted.replace(word, myMapConverted.get(word) + 1);
			} else {
				myMapConverted.put(word, 1);
			}
		}
		return myMapConverted;
	}

}
