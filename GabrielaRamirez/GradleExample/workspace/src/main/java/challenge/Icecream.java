package challenge;

import org.apache.log4j.Logger;

public class Icecream {

    public static Logger logJava = Logger.getLogger(Icecream.class);

    public final String BRAND = "La Michoacana";

    public void printFlavour(String flavour){
        logJava.info(flavour + " icecream");
    }

    public void topping(String topping){
        logJava.info("Your topping is: " + topping);
    }
    public void topping(String topping, String topping2){
        logJava.info("Your toppings are: " + topping + " " +  topping2);
    }
    public void topping(String topping, String topping2, String topping3){
        logJava.info("Your toppings are: " + topping + " " + topping2 + " " + topping3);
    }
}