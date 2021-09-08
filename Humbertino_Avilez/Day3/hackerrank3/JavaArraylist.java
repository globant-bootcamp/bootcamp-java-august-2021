package hackerrank3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArraylist {
	static List<List<Integer>> mainList = new ArrayList<List<Integer>>();
	static Scanner scanner = new Scanner(System.in);
	static String[] elements;
	static List<Integer> temporaryList;
	static final String MESSAGE_ERROR = "ERROR!";
	static final String SPLIT_SYMBOL = " ";

	public static void main(String[] args) {
		int lines = scanner.nextInt();
		scanner.nextLine();
		while (lines > 0) {
			temporaryList = new ArrayList<>();
			elements = scanner.nextLine().split(SPLIT_SYMBOL);
			for (int i = 0; i < Integer.parseInt(elements[0]); i++) {
				temporaryList.add(Integer.parseInt(elements[i + 1]));
			}
			mainList.add(temporaryList);
			lines--;
		}
		int queries = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < queries; i++) {
			String[] query = scanner.nextLine().split(SPLIT_SYMBOL);
			try {
				System.out.println(mainList.get(Integer.parseInt(query[0]) - 1).get(Integer.parseInt(query[1]) - 1));
			} catch (Exception e) {
				System.out.println(MESSAGE_ERROR);
			}
		}
		scanner.close();
	}
}
