package collections;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ListExercise {
	public static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		List<Integer> myNumbersList = new ArrayList<Integer>();
		int totalElementsListScan = SCANNER.nextInt();

		for (int index = 0; index < totalElementsListScan; index++) {
			int elementScan = SCANNER.nextInt();
			myNumbersList.add(elementScan);
		}

		int totalQueries = SCANNER.nextInt();
		for (int index = 0; index < totalQueries; index++) {
			String queryScan = SCANNER.next();
			if (queryScan.equalsIgnoreCase("insert")) {
				int addAtIndex = SCANNER.nextInt();
				int addElementAtIndex = SCANNER.nextInt();
				myNumbersList.add(addAtIndex, addElementAtIndex);
			} else {
				int deleteElementFromIndex = SCANNER.nextInt();
				myNumbersList.remove(deleteElementFromIndex);
			}
		}

		myNumbersList.forEach(myNumber -> System.out.print(myNumber + " "));
	}
}
