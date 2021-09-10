package challenge;

import org.apache.log4j.Logger;

public class Icecream {

    public static Logger LOG_JAVA = Logger.getLogger(Icecream.class);

    public final String BRAND = "La Michoacana";
    public static final String YOUR_TOPPING = "Your topping is: ";
    public static final String YOUR_TOPPINGS = "Your toppings are: ";
    public static final String SPACE = " ";
    public static final String ICE_CREAM = " icecream";

    public void printFlavour(String flavour){
        LOG_JAVA.info(flavour + ICE_CREAM);
    }

    public void topping(String topping){
        LOG_JAVA.info(YOUR_TOPPING + topping);
    }
    public void topping(String topping, String topping2){
        LOG_JAVA.info(YOUR_TOPPINGS  + topping + SPACE +  topping2);
    }
    public void topping(String topping, String topping2, String topping3){
        LOG_JAVA.info(YOUR_TOPPINGS  + topping + SPACE + topping2 + SPACE + topping3);
    }
}