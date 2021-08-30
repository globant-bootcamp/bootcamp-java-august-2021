package challenges.one;

import java.util.Scanner;

public class IfElse {

	public static final Scanner SCANNER = new Scanner(System.in);
	public static final String WEIRD_NUMBER = "Weird";
	public static final String NOT_WEIRD_NUMBER = "Not Weird";

	public static void main(String[] args) {

		int number = SCANNER.nextInt();

		if (number % 2 == 0) {
			if ((number >= 2 && number <= 5) || number > 20) {
				System.out.println(NOT_WEIRD_NUMBER);
			} else {
				System.out.println(WEIRD_NUMBER);
			}
		} else {
			System.out.println(WEIRD_NUMBER);
		}

		SCANNER.close();
	}
}
