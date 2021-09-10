package challenge;

import org.apache.log4j.Logger;

public class Main {

    public static Logger LOG_JAVA = Logger.getLogger(Main.class);

    public static final String COCO = "coconut";
    public static final String CHOCOLATE = "chocolate";
    public static final String MAMEY = "mamey";
    public static final String NUTS = "nuts";
    public static final String BANANA = "banana";
    public static final String STRAWBERRY = "strawberry";

    public static void main(String[] args){
        Icecream icecream = new Icecream();
        LOG_JAVA.info(icecream.BRAND);
        icecream.printFlavour(COCO);
        icecream.topping(CHOCOLATE);

        SnowIceCream snowIceCream = new SnowIceCream();
        snowIceCream.printFlavour(MAMEY);
        snowIceCream.topping(NUTS, CHOCOLATE);

        Popsicle popsicle = new Popsicle();
        popsicle.printFlavour(BANANA);
        popsicle.topping(STRAWBERRY, CHOCOLATE, NUTS);
    }
}
