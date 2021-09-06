package hackerrank3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
	static Map<String, Integer> directoryHashMap = new HashMap<String, Integer>();
	static Scanner scanner = new Scanner(System.in);
	static final String MESSAGE_DIGITS_REQUIRED = "number must have 8 digits";
	static final String MESSAGE_ERROR = "Not found";
	static final String EQUALITY_SYMBOL = "=";

	public static void main(String[] args) {
		int elements = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < elements; i++) {
			String name = scanner.nextLine().toLowerCase();
			int phone = scanner.nextInt();
			while (String.valueOf(phone).length() > 8) {
				System.out.println(MESSAGE_DIGITS_REQUIRED);
				phone = scanner.nextInt();
			}
			directoryHashMap.put(name, phone);
			scanner.nextLine();
		}
		while (scanner.hasNext()) {
			String name = scanner.nextLine();
			Integer number = directoryHashMap.get(name);
			if (number == null) {
				System.out.println(MESSAGE_ERROR);
			} else {
				System.out.println(name + EQUALITY_SYMBOL + number);
			}
		}
		scanner.close();
	}
}
