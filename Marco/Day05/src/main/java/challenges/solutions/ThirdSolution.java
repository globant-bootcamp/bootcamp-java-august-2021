package challenges.solutions;

import challenges.Main;
import lombok.extern.log4j.Log4j2;

import java.text.NumberFormat;
import java.util.Locale;

@Log4j2

public class ThirdSolution {

    public static void solve() {

        String paymentMessage = "Enter a number to format: ";
        log.info(paymentMessage);
        double payment = Main.SCAN.nextDouble();

        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat usaFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat indianFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat chineseFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat frenchFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);


        String us = "US: " + usaFormat.format(payment);
        String india = "India: " + indianFormat.format(payment);
        String china = "China: " + chineseFormat.format(payment);
        String france = "France: " + frenchFormat.format(payment);

        log.info(us);
        log.info(india);
        log.info(china);
        log.info(france);
    }


}
