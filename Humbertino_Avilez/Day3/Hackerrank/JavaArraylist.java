package hackerrank3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArraylist {
	static List<List<Integer>> mainList = new ArrayList<List<Integer>>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int lines = sc.nextInt();
		sc.nextLine();
		while (lines > 0) {
			List<Integer> temporaryList = new ArrayList<>();
			String[] elements = sc.nextLine().split(" ");
			for (int i = 0; i < Integer.parseInt(elements[0]); i++) {
				temporaryList.add(Integer.parseInt(elements[i + 1]));
			}
			mainList.add(temporaryList);
			lines--;
		}
		int queries = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < queries; i++) {
			String[] query = sc.nextLine().split(" ");
			try {
				System.out.println(mainList.get(Integer.parseInt(query[0]) - 1).get(Integer.parseInt(query[1]) - 1));
			} catch (Exception e) {
				System.out.println("ERROR!");
			}
		}
		sc.close();
	}
}
