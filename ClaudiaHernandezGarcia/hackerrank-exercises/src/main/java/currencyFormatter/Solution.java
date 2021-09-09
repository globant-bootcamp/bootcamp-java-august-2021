package currencyFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    private static final Logger logger = LogManager.getLogger(javaStaticInitializerBlock.Solution.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat numberFormatUS = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat numberFormatIndia = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat numberFormatChinese = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat numberFormatFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        logger.debug("US: " + numberFormatUS.format(payment));
        logger.debug("India: " + numberFormatIndia.format(payment));
        logger.debug("China: " + numberFormatChinese.format(payment));
        logger.debug("France: " + numberFormatFrance.format(payment));
    }
}
