package hackerrank;

import java.util.Scanner;

public class JavaStdinandStdout2 {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int i = scanner.nextInt();
		double d = scanner.nextDouble();
		String s = scanner.nextLine();

		s = scanner.nextLine();
		System.out.println("String: " + s);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);
		scanner.close();
	}

}
