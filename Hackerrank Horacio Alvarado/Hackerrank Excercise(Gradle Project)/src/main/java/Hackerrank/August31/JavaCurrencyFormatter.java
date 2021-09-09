package Hackerrank.August31;

import java.util.*;
import java.text.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class JavaCurrencyFormatter {
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String COUNTRY_INDIA = "in";
    public static final String INDIA = "India: ";
    public static final String CHINA = "China: ";
    public static final String FRANCE = "France: ";
    public static final String USA = "US: ";
    static final Logger LOGGER = LogManager.getLogger(JavaCurrencyFormatter.class);

    public static void solution(String[] args) {
        Scanner scanInput = new Scanner(System.in);

        double payment = scanInput.nextDouble();
        scanInput.close();

        String usFormat =  NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String indiaFormat =  NumberFormat.getCurrencyInstance(new Locale(LANGUAGE_ENGLISH,COUNTRY_INDIA)).format(payment);
        String chinaFormat =  NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String franceFormat =  NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        LOGGER.debug(USA + usFormat);
        LOGGER.debug(INDIA + indiaFormat);
        LOGGER.debug(CHINA + chinaFormat);
        LOGGER.debug(FRANCE + franceFormat);
    }
}
