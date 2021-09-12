package ConcurrencyFormatter;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ConcurrencyFormatter {

    static final String USA = "USA: ";
    static final String INDIA = "India: ";
    static final String CHINA = "China: ";
    static final String FRANCE = "France: ";

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        scanner.close();

        String usaCurrency = NumberFormat.getCurrencyInstance(Locale.US).format(amount);
        String indiaCurrency = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(amount);
        String chinaCurrency = NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount);
        String franceCurrency = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(amount);

        logger.info(USA + usaCurrency);
        logger.info(INDIA + indiaCurrency);
        logger.info(CHINA + chinaCurrency);
        logger.info(FRANCE + franceCurrency);

    }
}
