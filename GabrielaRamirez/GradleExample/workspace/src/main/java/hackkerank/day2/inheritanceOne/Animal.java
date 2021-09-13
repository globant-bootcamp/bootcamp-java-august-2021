package hackkerank.day2.inheritanceOne;
import org.apache.log4j.Logger;

class Animal{

    public static Logger LOG_JAVA = Logger.getLogger(Animal.class);

    public static final String WALKING = "I am walking";

    void walk() {
        LOG_JAVA.info(WALKING);
    }
}