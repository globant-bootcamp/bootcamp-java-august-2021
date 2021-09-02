package bootcamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maps {
	final static String numberOfInputs = "Enter the count of phone numbers: ";
	final static String tryAgainMessage = "Try Again";
	final static String tryAgainPhoneMessage = "Each phone number has exactly 8 digits without any leading zeros";
	final static Map<String, Integer> phoneNumberList = new HashMap<String, Integer>();
	final static String enterName = "Enter name of the contact: ";
	final static String enterQueries = "Enter the number of Queries: ";
	final static String phone = "Enter the phone of the contact: ";
	final static String error = "Error!";

	public static void numberOfPhones() {
		System.out.println(numberOfInputs);
		int contactCount;
		do {
			contactCount = isNumber();
		} while (contactCount <= 0 && contactCount >= 100000);
		goingToAdd(contactCount);
	}

	private static void goingToAdd(int contactCount) {
		for (int i = 1; i <= contactCount; i++) {
			System.out.println(enterName);
			Scanner scanner = new Scanner(System.in);
			String nameContact = scanner.next();
			System.out.println(phone);
			int phoneNumber = isPhoneNumber();
			phoneNumberList.put(nameContact, phoneNumber);
		}
		enterQueries();
	}

	private static void enterQueries() {
		System.out.println(enterQueries);
		int queries;
		do {
			queries = isNumber();
		} while (queries <= 0 && queries >= 10000);
		for (int i = 0; i < queries; i++) {
			System.out.println(enterName);
			Scanner scanner = new Scanner(System.in);
			String nameContact = scanner.next();
			if (phoneNumberList.containsKey(nameContact)) {
				System.out.println(phoneNumberList.get(nameContact));
			}else {
				System.out.println(error);
			}

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

	static int isPhoneNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			boolean nextStep;
			try {
				String number = scanner.next();
				Integer.parseInt(number);
				if (number.length() == 8 && !(number.startsWith("0"))) {
					nextStep = true;
					return Integer.parseInt(number);
				} else {
					System.out.println(tryAgainPhoneMessage);
				}
			} catch (Exception e) {
				System.out.println(tryAgainPhoneMessage);
			}
		} while (!false);
	}
}
