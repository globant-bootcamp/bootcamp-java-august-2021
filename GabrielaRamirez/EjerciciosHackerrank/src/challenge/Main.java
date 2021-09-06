package challenge;

public class Main {

    public static void main(String[] args){
        Icecream icecream = new Icecream();
        System.out.println(icecream.BRAND);
        icecream.printFlavour("coconut");
        icecream.topping("chocolate");


        Nieve nieve = new Nieve();
        nieve.printFlavour("Mamey");
        nieve.topping("nuts", "chocolate");

        Paleta paleta = new Paleta();
        paleta.printFlavour("banaba");
        paleta.topping("strawberry", "chocolate", "nuts");
    }
}
