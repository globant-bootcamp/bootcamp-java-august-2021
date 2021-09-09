package bootcamp;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class JavaCurrencyFormatter {
    private static final Logger logger = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        logger.info("US: " + NumberFormat.getCurrencyInstance(new Locale("en","US")).format(payment));
        logger.info("India: " + NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(payment));
        logger.info("China: " + NumberFormat.getCurrencyInstance(new Locale("zh","CN")).format(payment));
        logger.info("France: " + NumberFormat.getCurrencyInstance(new Locale("fr","FR")).format(payment));
    }
}