package collections;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ArrayListExercise {

	public static final Scanner SCAN = new Scanner(System.in);

	public static void main(String[] args) {
		int sizeOfList = SCAN.nextInt();
		List<List> myList = new ArrayList<List>();

		for (int index = 0; index < sizeOfList; index++) {
			int totalOfElementsInSubList = SCAN.nextInt();
			int count = 0;
			ArrayList<Integer> mySubListOfNumbers = new ArrayList<Integer>();

			while (count < totalOfElementsInSubList) {
				mySubListOfNumbers.add(SCAN.nextInt());
				count++;
			}
			myList.add(mySubListOfNumbers);
		}

		int queries = SCAN.nextInt();
		int count = 0;
		while (count < queries) {
			int numbers = SCAN.nextInt() - 1;
			int position = SCAN.nextInt() - 1;

			System.out.println((myList.size() <= numbers || myList.get(numbers).size() <= position ? "ERROR!"
					: myList.get(numbers).get(position)));
			count += 1;
		}
	}

}
