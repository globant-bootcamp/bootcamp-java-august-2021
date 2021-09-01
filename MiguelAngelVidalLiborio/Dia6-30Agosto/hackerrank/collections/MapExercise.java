package collections;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class MapExercise {
	public static final Scanner SCAN = new Scanner(System.in);

	public static void main(String[] args) {
		Map<String, Integer> myMap = new HashMap<String, Integer>();

		int numberOfEntriesScan = SCAN.nextInt();
		SCAN.nextLine();

		for (int i = 0; i < numberOfEntriesScan; i++) {
			String userName = SCAN.nextLine();
			int userPhone = SCAN.nextInt();
			SCAN.nextLine();
			myMap.put(userName, userPhone);
		}

		while (SCAN.hasNext()) {
			String userQuery = SCAN.nextLine();
			System.out.println(myMap.containsKey(userQuery) ? String.format("%s=%d", userQuery, myMap.get(userQuery))
					: "Not found");
		}
	}

}
