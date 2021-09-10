package challenge;

public class Popsicle extends Icecream{
    @Override
    public void printFlavour(String flavour){
        logJava.info("This is a " + flavour + " Popsicle");
    }
}
