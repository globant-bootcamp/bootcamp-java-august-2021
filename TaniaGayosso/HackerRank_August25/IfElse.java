package challenges.one;

import java.util.Scanner;

public class IfElse {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		final int NUMBER = scanner.nextInt();
		final String MESSAGE;
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		if (NUMBER % 2 == 1) {
			MESSAGE = "Weird";
		} else {
			if (NUMBER >= 2 && NUMBER <= 5) {
				MESSAGE = "Not Weird";
			} else if (NUMBER >= 6 && NUMBER <= 20) {
				MESSAGE = "Weird";
			} else {
				MESSAGE = "Not Weird";
			}
		}
		scanner.close();
		System.out.println(MESSAGE);
	}
}
