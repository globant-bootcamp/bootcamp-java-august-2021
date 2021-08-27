package hackerrank;

import java.util.Scanner;

public class JavaStdinandStdout {

	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();
		int thirdNumber = scanner.nextInt();

		System.out.println(firstNumber);
		System.out.println(secondNumber);
		System.out.println(thirdNumber);
		scanner.close();
	}

}
