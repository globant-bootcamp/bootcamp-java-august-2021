package hackkerank.day2.inheritanceOne;

import hackkerank.day1.IfElse;
import org.apache.log4j.Logger;

class Animal{

    public static Logger logJava = Logger.getLogger(Animal.class);

    void walk()
    {
        logJava.info("I am walking");
    }
}