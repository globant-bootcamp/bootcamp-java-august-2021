package hackerrank.day4.currencyformatter;

import lombok.extern.log4j.Log4j2;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 01/09/21
 */
@Log4j2
public class ExerciseFormatter {
    public static final String LANGUAGE_ENGLISH = "EN";
    public static final String COUNTRY_INDIA = "IN";
    public static final String INDIA = "India : ";
    public static final String CHINA = "China : ";
    public static final String FRANCE = "France : ";
    public static final String USA = "United States : ";
    static double payment;

    static {
        Scanner scanner = new Scanner(System.in);
        payment = scanner.nextDouble();
    }

    public static void getCountryFormat() {
        String usa = USA + NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = INDIA + NumberFormat.getCurrencyInstance(new Locale(LANGUAGE_ENGLISH, COUNTRY_INDIA))
                .format(payment);
        String china = CHINA + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = FRANCE + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        log.debug("{}{}{}{}", usa, india, china, france);
    }
}
