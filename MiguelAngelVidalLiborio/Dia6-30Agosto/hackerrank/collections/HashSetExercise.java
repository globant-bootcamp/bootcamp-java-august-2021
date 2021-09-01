package collections;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class HashSetExercise {
	public static final Scanner SCAN = new Scanner(System.in);

	public static void main(String[] args) {
		int numberOfPairs = SCAN.nextInt();
		String[] pair_left = new String[numberOfPairs];
		String[] pair_right = new String[numberOfPairs];

		for (int i = 0; i < numberOfPairs; i++) {
			pair_left[i] = SCAN.next();
			pair_right[i] = SCAN.next();
		}

		Set<String> mySet = new HashSet<String>();
		int count = 0;
		while (count < numberOfPairs) {
			mySet.add(pair_left[count] + " " + pair_right[count]);
			System.out.println(mySet.size());
			count++;
		}
		
	}
}
