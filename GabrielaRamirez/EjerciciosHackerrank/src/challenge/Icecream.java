package challenge;

public class Icecream {

    public final String BRAND = "La Michoacana";

    public void printFlavour(String flavour){
        System.out.println(flavour + " icecream");
    }

    public void topping(String topping){
        System.out.println("Your topping is: " + topping);
    }
    public void topping(String topping, String topping2){
        System.out.println("Your toppings are: " + topping + topping2);
    }
    public void topping(String topping, String topping2, String topping3){
        System.out.println("Your toppings are: " + topping + topping2 + topping3);
    }
}