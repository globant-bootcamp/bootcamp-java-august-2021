package javahashtable;

import java.util.Hashtable;
import java.util.List;

class Result {
	static final String ANSWER_YES = "Yes";
	static final String ANSWER_NO = "No";

	public static void checkMagazine(List<String> magazineList, List<String> noteList) {
		Hashtable<String, Integer> noteHashTable = new Hashtable<String, Integer>();
		Hashtable<String, Integer> magazineHashTable = new Hashtable<String, Integer>();
		for (int i = 0; i < noteList.size(); i++) {
			if (noteHashTable.containsKey(noteList.get(i))) {
				noteHashTable.put(noteList.get(i), noteHashTable.get(noteList.get(i)) + 1);
			} else {
				noteHashTable.put(noteList.get(i), 1);
				magazineHashTable.put(noteList.get(i), 0);
			}
		}
		for (int i = 0; i < magazineList.size(); i++) {
			if (magazineHashTable.containsKey(magazineList.get(i))) {
				magazineHashTable.put(magazineList.get(i), magazineHashTable.get(magazineList.get(i)) + 1);
			}
		}
		if (noteHashTable.equals(magazineHashTable)) {
			System.out.println(ANSWER_YES);
		} else {
			System.out.println(ANSWER_NO);
		}
	}
}
