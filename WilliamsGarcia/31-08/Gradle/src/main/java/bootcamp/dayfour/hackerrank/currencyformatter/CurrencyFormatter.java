package bootcamp.dayfour.hackerrank.currencyformatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CurrencyFormatter {

    static final Logger LOGGER = LogManager.getLogger(CurrencyFormatter.class);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double payment = scan.nextDouble();
        scan.close();

        NumberFormat usNumberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat chinaNumberFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceNumberFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat indiaNumberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "in"));

        LOGGER.info("US: " + usNumberFormat.format(payment));
        LOGGER.info("India: " + indiaNumberFormat.format(payment));
        LOGGER.info("China: " + chinaNumberFormat.format(payment));
        LOGGER.info("France: " + franceNumberFormat.format(payment));
    }
}
