package challenge;

public class Popsicle extends Icecream{
    @Override
    public void printFlavour(String flavour){
        LOG_JAVA.info("This is a " + flavour + " Popsicle");
    }
}
