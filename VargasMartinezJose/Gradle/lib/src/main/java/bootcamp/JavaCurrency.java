package bootcamp;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class JavaCurrency {
    public static void main(String[] args) {
        final Logger LOGGER = Logger.getLogger("bootcamp.JavaCurrency");
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        final String INDIA = "IN: ";
        final String US = "US: ";
        final String CHINA = "China: ";
        final String FRANCE = "France: ";

        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        LOGGER.debug(US + us.format(payment));
        LOGGER.debug(INDIA + india.format(payment));
        LOGGER.debug(CHINA + china.format(payment));
        LOGGER.debug(FRANCE + france.format(payment));
        scanner.close();
    }
}
