package gradleProyect;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

    public static void CurrencyFormatter() {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + usFormat.format(payment)
                + "\nIndia: " + indiaFormat.format(payment)
                + "\nChina: " + chinaFormat.format(payment)
                + "\nFrance: " + franceFormat.format(payment));
    }

}
