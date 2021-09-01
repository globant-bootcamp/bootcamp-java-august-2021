package bootcamp;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;;

public class ArrayLists {
	static ArrayList<number> numbers = new ArrayList<number>();
	static String numberOfRows = "Enter the number of Rows: ";
	static String numberOfRowsFinal = "Your number of Rows: ";
	static String tryAgainMessage = "Try Again";
	static String lengthOfRow = "Enter how many inputs for this row: ";
	static String messageRow = "You are in row: ";
	static String enterInput = "Enter your input: ";
	static String enterX = "Enter x coordenate: ";
	static String enterY = "Enter y coordenate: ";
	static String enterQueries = "Enter the number of Queries: ";
	static String value = "The value from the coordenates: ";
	static String error = "Error!";

	public static void numberOfRows() {
		System.out.println(numberOfRows);
		int finalNumberOfRows;
		do {
			finalNumberOfRows = isNumber();
		} while (finalNumberOfRows <= 0 && finalNumberOfRows >= 20000);

		System.out.println(numberOfRowsFinal + finalNumberOfRows);
		fillRow(finalNumberOfRows);
	}

	public static void fillRow(int inputs) {
		for (int i = 1; i <= inputs; i++) {
			System.out.println(messageRow + (i));
			System.out.println(lengthOfRow);
			int numberOfInputs;
			do {
				numberOfInputs = isNumber();
			} while (inputs <= 0 && inputs >= 50000);
			if (numbers.size() >= 100000)
				break;
			for (int j = 1; j <= numberOfInputs; j++) {
				System.out.println(enterInput);
				int value = isNumber();
				number numberToList = new number(i, j, value);
				numbers.add(numberToList);
			}
		}
		enterCoordenates();
	}

	public static void enterCoordenates() {
		System.out.println(enterQueries);
		int queries;
		do {
			queries = isNumber();
		} while (queries <= 0 && queries >= 20000);
		for (int i = 0; i < queries; i++) {
			System.out.println(enterX);
			int x = isNumber();
			System.out.println(enterY);
			int y = isNumber();
			if (!findNumber(x, y))
				System.out.println(error);
		}
	}

	public static boolean findNumber(int x, int y) {
		for (number number : numbers) {
			if (number.getX() == x && number.getY() == y) {
				System.out.println(value + number.getValue());
				return true;
			}
		}
		return false;

	}

	static int isNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			boolean nextStep = false;
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
