package hackerrank3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
	static Map<String, Integer> directory = new HashMap<String, Integer>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int elements = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < elements; i++) {
			String name = sc.nextLine().toLowerCase();
			int phone = sc.nextInt();
			while (String.valueOf(phone).length() > 8) {
				System.out.println("number must have 8 digits");
				phone = sc.nextInt();
			}
			directory.put(name, phone);
			sc.nextLine();
		}
		while (sc.hasNext()) {
			String name = sc.nextLine();
			Integer number = directory.get(name);
			if (number == null) {
				System.out.println("Not found");
			} else {
				System.out.println(name + "=" + number);
			}
		}
		sc.close();
	}
}
