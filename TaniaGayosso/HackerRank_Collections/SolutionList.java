package challenges.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionList {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		List<Integer> myIntegersList = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			myIntegersList.add(scanner.nextInt());
		}

		int numberOfQueries = scanner.nextInt();

		for (int i = 0; i < numberOfQueries; i++){
			String queryAction = scanner.next();

			if (queryAction.equals("Insert")){
				int indexX = scanner.nextInt();
				int valueY = scanner.nextInt();
				myIntegersList.add(indexX, valueY);

			} else{
				int indexX = scanner.nextInt();
				myIntegersList.remove(indexX);
			}
		}
		for (Integer numbers : myIntegersList){
			System.out.print(numbers + " ");
		}
	}
}