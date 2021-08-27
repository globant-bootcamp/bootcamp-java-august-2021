package hackerrank;

import java.util.Scanner;

public class JavaIfElse {

	public static final String NOT_WEIRD = "Not Weird";
	public static final String WEIRD = "Weird";
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int number = scanner.nextInt();
		int modulus = number % 2;

		if (modulus == 0 && (number >= 2 && number <= 5)) {
			System.out.println(NOT_WEIRD);

		} else if (modulus == 0 && (number >= 6 && number <= 20) || modulus == 1) {
			System.out.println(WEIRD);

		} else {
			System.out.println(NOT_WEIRD);
		}
		scanner.close();
	}

}
