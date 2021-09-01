package bootcamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
	static String wordsMagazine = "Enter the number of words in the magazine: ";
	static String wordsNote = "Enter the number of words in the note: ";
	static String word = "Enter the word: ";
	static String yes = "YES";
	static String no = "NO";
	static String tryAgainMessage = "Try Again";
	static HashSet<String> noteWords = new HashSet<String>();
	static HashSet<String> magazineWords = new HashSet<String>();

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
			magazineWords.add(word);
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
			noteWords.add(word);
		}
		compareSets();
	}

	static void compareSets() {
		int count = 0;
		for (String note : noteWords) {
			for (String magazine : magazineWords) {
				if (note.contentEquals(magazine)) {
					count++;
				}
			}
		}
		if (count == noteWords.size())
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
