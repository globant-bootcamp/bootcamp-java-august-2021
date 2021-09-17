package currencyFormatter;

import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter {

  static final String CURRENCY_FORMATTER = "Java Currency Formatter";
  static final String US = "US: ";
  static final String INDIA = "India: ";
  static final String CHINA = "China: ";
  static final String FRANCE = "France: ";

  static Logger log = Logger.getLogger(CURRENCY_FORMATTER);

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);
    double payment = readLineTerminal.nextDouble();
    readLineTerminal.close();

    String unitedStatesPayment = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
    String indiaPayment = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
    String chinaPayment = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
    String francePayment = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

    log.info(US + unitedStatesPayment);
    log.info(INDIA + indiaPayment);
    log.info(CHINA + chinaPayment);
    log.info(FRANCE + francePayment);
  }

}
