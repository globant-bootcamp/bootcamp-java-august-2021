package hackerrank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

public class JavaCurrencyFormatter {
	private static final Logger javaLog = Logger.getLogger(Main.class);
	static Scanner scanner = new Scanner(System.in);
	static NumberFormat numberFormatUS = NumberFormat.getCurrencyInstance(Locale.US);
	static NumberFormat numberFormatChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
	static NumberFormat numberFormatFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);
	static NumberFormat numberFormatIndia = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
	static final String US = "US: ";
	static final String INDIA = "India: ";
	static final String CHINA = "China: ";
	static final String FRANCE = "France: ";

	public static void main(String[] args) {
		Double payment = scanner.nextDouble();
		javaLog.debug(US + numberFormatUS.format(payment));
		javaLog.debug(INDIA + numberFormatIndia.format(payment));
		javaLog.debug(CHINA + numberFormatChina.format(payment));
		javaLog.debug(FRANCE + numberFormatFrance.format(payment));
	}
}
