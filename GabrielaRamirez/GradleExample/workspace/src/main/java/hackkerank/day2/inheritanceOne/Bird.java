package hackkerank.day2.inheritanceOne;

import org.apache.log4j.Logger;

class Bird extends Animal {

    public static Logger logJava = Logger.getLogger(Bird.class);

    void fly() {
        logJava.info("I am flying");
    }

    void sing() {
        logJava.info("I am singing");
    }
}