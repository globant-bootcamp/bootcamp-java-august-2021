package bootcamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ArrayLists {
	final static List<number> numberList = new ArrayList<number>();
	final static String numberOfRows = "Enter the number of Rows: ";
	final static String numberOfRowsFinal = "Your number of Rows: ";
	final static String tryAgainMessage = "Try Again";
	final static String lengthOfRow = "Enter how many inputs for this row: ";
	final static String messageRow = "You are in row: ";
	final static String enterInput = "Enter your input: ";
	final static String enterX = "Enter x coordinate: ";
	final static String enterY = "Enter y coordinate: ";
	final static String enterQueries = "Enter the number of Queries: ";
	final static String value = "The value from the coordinates: ";
	final static String error = "Error!";

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
			if (numberList.size() >= 100000)
				break;
			for (int j = 1; j <= numberOfInputs; j++) {
				System.out.println(enterInput);
				int value = isNumber();
				number numberToList = new number(i, j, value);
				numberList.add(numberToList);
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
			int coordinateX = isNumber();
			System.out.println(enterY);
			int coordinateY = isNumber();
			if (!findNumber(coordinateX, coordinateY))
				System.out.println(error);
		}
	}

	public static boolean findNumber(int coordinateX, int coordinateY) {
		for (number number : numberList) {
			if (number.getCoordinateX() == coordinateX && number.getCoordinateY() == coordinateY) {
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

