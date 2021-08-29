package ChallengesOne;

import java.util.Scanner;

public class StdInStdOut {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int firstNumber = scan.nextInt();
		int secondNumber = scan.nextInt();
		int thirdNumber = scan.nextInt();
		scan.close();

		System.out.println(firstNumber);
		System.out.println(secondNumber);
		System.out.println(thirdNumber);

	}
}