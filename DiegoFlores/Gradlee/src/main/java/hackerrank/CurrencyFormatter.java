import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Solution {
    
    public static final String US_MESSAGE = "US: ";
    public static final String INDIA_MESSAGE = "India: ";
    public static final String CHINA_MESSAGE = "China: ";
    public static final String FRANCE_MESSAGE = "France: ";
    public static final String LANGUAGE = "en";
    public static final String COUNTRY = "IN";

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        NumberFormat usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat chinaCurrency = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat indFormatter = NumberFormat.getCurrencyInstance(new Locale(LANGUAGE, COUNTRY)); 
        NumberFormat franceCurrency = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        
        System.out.println(US_MESSAGE + usCurrency.format(payment));
        System.out.println(INDIA_MESSAGE + indFormatter.format(payment));
        System.out.println(CHINA_MESSAGE + chinaCurrency.format(payment));
        System.out.println(FRANCE_MESSAGE + franceCurrency.format(payment));
        
    }
    
}
