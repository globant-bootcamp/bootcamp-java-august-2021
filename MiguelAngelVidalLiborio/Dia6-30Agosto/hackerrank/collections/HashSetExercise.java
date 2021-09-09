package collections;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class HashSetExercise {
	public static final Scanner SCAN = new Scanner(System.in);

	public static void main(String[] args) {
		int numberOfPairs = SCAN.nextInt();
		String[] pairLeft = new String[numberOfPairs];
		String[] pairRight = new String[numberOfPairs];

		for (int i = 0; i < numberOfPairs; i++) {
			pairLeft[i] = SCAN.next();
			pairRight[i] = SCAN.next();
		}

		Set<String> mySet = new HashSet<String>();
		int count = 0;
		while (count < numberOfPairs) {
			mySet.add(pairLeft[count] + " " + pairRight[count]);
			System.out.println(mySet.size());
			count++;
		}

	}
}
