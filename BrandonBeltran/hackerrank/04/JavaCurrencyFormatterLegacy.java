package bootcamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class JavaCurrencyFormatterLegacy {
    private static final Logger logger = LogManager.getLogger(JavaCurrencyFormatterLegacy.class);

    private static final String EMPTY_STRING = "";
    private static final String US_CURRENCY_SIGN = "$";
    private static final String INDIA_CURRENCY_SIGN = "Rs.";
    private static final String CHINA_CURRENCY_SIGN = "￥";
    private static final String FRANCE_CURRENCY_SIGN = "€";

    public static void main(String[] args) {

        /* This solution was made before I realized NumberFormat.getCurrencyInstance() existed.
         * It's preserved here just for completion purposes */


        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String [] paymentString = String.valueOf(payment).split("\\.", 0);
        String decimals = paymentString[1].substring(0,2);
        String numerals = paymentString[0];

        List<String> splittedString = splitEveryN(numerals, 3);

        String commaSeparated = splittedString.stream().map(Object::toString).
                collect(Collectors.joining(",")).toString();
        String spaceSeparated = commaSeparated.replaceAll(",", " ");

        String us = US_CURRENCY_SIGN+commaSeparated+"."+decimals;
        String india = INDIA_CURRENCY_SIGN+commaSeparated+"."+decimals;
        String china = CHINA_CURRENCY_SIGN+commaSeparated+"."+decimals;
        String france = commaSeparated+","+decimals+" "+FRANCE_CURRENCY_SIGN;

        logger.info("US: " + us);
        logger.info("India: " + india);
        logger.info("China: " + china);
        logger.info("France: " + france);



    }

    public static List<String> splitEveryN(String string, int nLength){
        List<String> splittedString = new ArrayList<>();

        int positionSpliter = 0;
        if((string.length()%nLength) != 0){
            positionSpliter = nLength - (string.length()%nLength);
        }

        String tempStringContainer = EMPTY_STRING;

        for(int iterator = 0; iterator<string.length(); iterator++){
            tempStringContainer += string.charAt(iterator);

            if(positionSpliter == nLength-1){
                splittedString.add(tempStringContainer);
                tempStringContainer = EMPTY_STRING;
                positionSpliter = 0;
            }else{
                positionSpliter++;
            }
        }

        if(!tempStringContainer.equals(EMPTY_STRING)) splittedString.add(tempStringContainer);

        return splittedString;
    }

}
