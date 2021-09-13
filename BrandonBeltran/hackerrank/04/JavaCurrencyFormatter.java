package bootcamp;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class JavaCurrencyFormatter {
    private static final Logger LOGGER = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        LOGGER.info("US: " + NumberFormat.getCurrencyInstance(new Locale("en","US")).format(payment));
        LOGGER.info("India: " + NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(payment));
        LOGGER.info("China: " + NumberFormat.getCurrencyInstance(new Locale("zh","CN")).format(payment));
        LOGGER.info("France: " + NumberFormat.getCurrencyInstance(new Locale("fr","FR")).format(payment));
    }
}