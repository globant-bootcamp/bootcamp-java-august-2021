package hackerrankExercises;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

    static final Logger logger = LogManager.getLogger(CurrencyFormatter.class);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double amountOfMoney = input.nextDouble();
        input.close();

        NumberFormat usaMoneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat indiaMoneyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        NumberFormat chinaMoneyFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceMoneyFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        logger.info("US: " + usaMoneyFormat.format(amountOfMoney));
        logger.info("India: " + indiaMoneyFormat.format(amountOfMoney));
        logger.info("China: " + chinaMoneyFormat.format(amountOfMoney));
        logger.info("France: " + franceMoneyFormat.format(amountOfMoney));
    }
}
