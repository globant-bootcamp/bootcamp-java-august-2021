package bootcamp;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class HashSets {
	static String numberOfInputs = "Enter the number of pairs: ";
	static String tryAgainMessage = "Try Again";
	static String enterFirstName = "Enter first name: ";
	static String enterSecondName = "Enter second: ";
	static String error = "Error!";
	static HashSet<String> names = new HashSet<String>();

	public static void main(String[] args) {
		numberOfInputs();
	}

	public static void numberOfInputs() {
		System.out.println(numberOfInputs);
		int pairNumbers;
		do {
			pairNumbers = isNumber();
		} while (pairNumbers <= 0 && pairNumbers >= 100000);
		goingToAdd(pairNumbers);
	}

	private static void goingToAdd(int pairNumbers) {
		for (int i = 1; i <= pairNumbers; i++) {
			System.out.println(enterFirstName);
			Scanner scanner = new Scanner(System.in);
			String firstName = scanner.next();
			System.out.println(enterSecondName);
			String secondName = scanner.next();
			String pair = firstName + " " + secondName;
			names.add(pair);
			System.out.println(names.size());
		}

	}

	static int isNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			boolean nextStep;
			try {
				String number = scanner.next();
				Integer.parseInt(number);
				nextStep = true;
				return Integer.parseInt(number);
			} catch (Exception e) {
				System.out.println(tryAgainMessage);
			}
		} while (!false);
	}
}
