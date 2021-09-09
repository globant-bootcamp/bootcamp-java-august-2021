package bootcamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
	final static String wordsMagazine = "Enter the number of words in the magazine: ";
	final static String wordsNote = "Enter the number of words in the note: ";
	final static String word = "Enter the word: ";
	final static String yes = "YES";
	final static String no = "NO";
	final static String tryAgainMessage = "Try Again";
	final static Set<String> noteWordSet = new HashSet<String>();
	final static Set<String> magazineWordSet = new HashSet<String>();

	public static void numberOfInputs() {
		System.out.println(wordsMagazine);
		int wordsMagazine;
		do {
			wordsMagazine = isNumber();
		} while (wordsMagazine <= 0 && wordsMagazine >= 100000);

		fillMagazine(wordsMagazine);
	}

	private static void fillMagazine(int wordsMagazine) {
		for (int i = 1; i <= wordsMagazine; i++) {
			System.out.println(word);
			Scanner scanner = new Scanner(System.in);
			String word;
			do {
				word = scanner.next();
			} while (word.length() < 5 && word.length() > 30);
			magazineWordSet.add(word);
		}
		System.out.println(wordsNote);
		int wordsNote;
		do {
			wordsNote = isNumber();
		} while (wordsNote <= 0 && wordsNote >= 100000);
		fillNote(wordsMagazine);
	}

	private static void fillNote(int wordsNote) {
		for (int i = 1; i <= wordsNote; i++) {
			System.out.println(word);
			Scanner scanner = new Scanner(System.in);
			String word;
			do {
				word = scanner.next();
			} while (word.length() < 5 && word.length() > 30);
			noteWordSet.add(word);
		}
		compareSets();
	}

	static void compareSets() {
		int count = 0;
		for (String note : noteWordSet) {
			for (String magazine : magazineWordSet) {
				if (note.contentEquals(magazine)) {
					count++;
				}
			}
		}
		if (count == noteWordSet.size())
			System.out.println(yes);
		else
			System.out.println(no);
	}

	static int isNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			boolean nextStep;
			try {
				String number = scanner.next();
				Integer.parseInt(number);
				nextStep = true;
				return Integer.parseInt(number);
			} catch (Exception e) {
				System.out.println(tryAgainMessage);
			}
		} while (!false);
	}
}

