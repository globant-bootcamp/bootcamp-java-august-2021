package javahashtable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class JavaHashTable {
	static Scanner scanner = new Scanner(System.in);
	static final String SPLIT_SYMBOL = " ";

	public static void main(String[] args) throws IOException {
		List<String> magazineList = new ArrayList<String>();
		List<String> noteList = new ArrayList<String>();
		String[] elements = scanner.nextLine().split(SPLIT_SYMBOL);
		int elementsMagazine = Integer.parseInt(elements[0]);
		int elementsNote = Integer.parseInt(elements[1]);
		String[] magazineWords = scanner.nextLine().split(SPLIT_SYMBOL);
		String[] noteWords = scanner.nextLine().split(SPLIT_SYMBOL);
		for (int i = 0; i < elementsMagazine; i++) {
			magazineList.add(magazineWords[i]);
		}
		for (int i = 0; i < elementsNote; i++) {
			noteList.add(noteWords[i]);
		}
		Result.checkMagazine(magazineList, noteList);
		scanner.close();
	}
}