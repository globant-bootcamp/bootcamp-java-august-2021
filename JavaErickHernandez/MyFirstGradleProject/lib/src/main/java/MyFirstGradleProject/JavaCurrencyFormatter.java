package MyFirstGradleProject;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class JavaCurrencyFormatter {
	private static final Logger LOG = Logger.getLogger(JavaStaticInitializer.class);
	final static String ENTER_MONEY = "Enter  amount of money: ";
	static String us;
	static String india;
	static String china;
	static String france;

	public static void main(String[] args) {
		enterPayment();
	}

	private static void enterPayment() {
		LOG.debug(ENTER_MONEY);
		double money = Validations.validDoubleNumber();
		printCurrencyInstance(money);
	}

	private static void printCurrencyInstance(double money) {
		String us = NumberFormat.getCurrencyInstance(Locale.US).format(money);
		String india = NumberFormat.getCurrencyInstance(new Locale("en", "RS.")).format(money);
		String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(money);
		String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(money);
		LOG.debug("US: " + us);
		LOG.debug("India: " + india);
		LOG.debug("China: " + china);
		LOG.debug("France: " + france);
	}

}
