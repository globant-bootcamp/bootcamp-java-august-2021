package challenges.collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SolutionHashSet {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numberOfPairs = scanner.nextInt();
		String[] pairLeft = new String[numberOfPairs];
		String[] pairRight = new String[numberOfPairs];

		for (int i = 0; i < numberOfPairs; i++) {
			pairLeft[i] = scanner.next();
			pairRight[i] = scanner.next();
		}
		scanner.close();

		Set<String> pairsSet = new HashSet<String>();
		for (int i = 0; i < numberOfPairs; i++) {
			pairsSet.add("(" + pairLeft[i] + "," + pairRight[i] + ")");
			System.out.println(pairsSet.size());
		}
	}
}
