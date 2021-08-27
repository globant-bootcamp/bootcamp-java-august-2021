package hackerrank;

import java.util.Scanner;

public class JavaStdinandStdout2 {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int myAgeTerminalScan = scanner.nextInt();
		double mySalaryTerminalScan = scanner.nextDouble();
		String myNameTerminalScan = scanner.nextLine();

		myNameTerminalScan = scanner.nextLine();
		System.out.println("String: " + myNameTerminalScan);
		System.out.println("Double: " + mySalaryTerminalScan);
		System.out.println("Int: " + myAgeTerminalScan);
		scanner.close();
	}

}
