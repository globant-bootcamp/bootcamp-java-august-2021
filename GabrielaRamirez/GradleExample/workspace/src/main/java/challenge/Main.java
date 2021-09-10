package challenge;

import org.apache.log4j.Logger;

public class Main {

    public static Logger logJava = Logger.getLogger(Main.class);

    public static void main(String[] args){
        Icecream icecream = new Icecream();
        logJava.info(icecream.BRAND);
        icecream.printFlavour("coconut");
        icecream.topping("chocolate");


        SnowIceCream nieve = new SnowIceCream();
        nieve.printFlavour("Mamey");
        nieve.topping("nuts", "chocolate");

        Popsicle popsicle = new Popsicle();
        popsicle.printFlavour("banaba");
        popsicle.topping("strawberry", "chocolate", "nuts");
    }
}
