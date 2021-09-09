package MyFirstGradleProject;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Validations {
	private static final Logger LOG = Logger.getLogger(JavaStaticInitializer.class);
	final static String TryAgainMessage = "Try Again";

	static double validDoubleNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			try {
				String number = scanner.next();
				Double.parseDouble(number);
				return Double.parseDouble(number);
			} catch (Exception e) {
				LOG.debug(TryAgainMessage);
			}
		} while (!false);
	}

	static int validNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			try {
				String number = scanner.next();
				Integer.parseInt(number);
				return Integer.parseInt(number);
			} catch (Exception e) {
				LOG.debug(TryAgainMessage);
			}
		} while (!false);
	}
}
