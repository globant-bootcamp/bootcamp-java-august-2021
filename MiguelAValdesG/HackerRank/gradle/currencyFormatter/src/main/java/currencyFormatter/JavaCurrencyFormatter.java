package currencyFormatter;

import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter {

  static Logger log = Logger.getLogger("Java Currency Formatter");

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);
    double payment = readLineTerminal.nextDouble();
    readLineTerminal.close();

    String unitedStatesPayment = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
    String indiaPayment = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
    String chinaPayment = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
    String francePayment = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

   log.info("US: " + unitedStatesPayment);
   log.info("India: " + indiaPayment);
   log.info("China: " + chinaPayment);
   log.info("France: " + francePayment);
  }

}
