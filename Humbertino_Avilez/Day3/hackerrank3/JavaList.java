package hackerrank3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
	static List<Integer> list = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	static String[] values;
	static final String CONSTRAINS_Q = "Constraints: 1 <= Q <= 400";
	static final String CONSTRAINS_N = "Constraints: 1 <= N <= 400";
	static final String OPCION_INSERT = "Insert";
	static final String OPCION_DELETE = "Delete";
	static final String SPLIT_SYMBOL = " ";

	public static void main(String[] args) {
		int elements = scanner.nextInt();
		if (elements >= 1 && elements <= 4000) {
			scanner.nextLine();
			values = scanner.nextLine().split(SPLIT_SYMBOL);
			for (int i = 0; i < elements; i++) {
				list.add(Integer.parseInt(values[i]));
			}
			int queries = scanner.nextInt();
			scanner.nextLine();
			if (elements >= 1 && elements <= 4000) {
				while (queries > 0) {
					String querie = scanner.next();
					scanner.nextLine();
					Option(querie);
					queries--;
				}
			} else {
				System.out.println(CONSTRAINS_Q);
			}
		} else {
			System.out.println(CONSTRAINS_N);
		}
		for (Integer number : list) {
			System.out.print(number + SPLIT_SYMBOL);
		}
		scanner.close();
	}

	public static void Option(String option) {
		if (option.equals(OPCION_INSERT)) {
			String[] valuesxy = scanner.nextLine().split(SPLIT_SYMBOL);
			list.add(Integer.parseInt(valuesxy[0]), Integer.parseInt(valuesxy[1]));
		} else if (option.equals(OPCION_DELETE)) {
			int index = scanner.nextInt();
			list.remove(index);
		}
	}
}
