package hackkerank.day2.inheritanceOne;

import org.apache.log4j.Logger;

class Bird extends Animal {

    public static Logger LOG_JAVA = Logger.getLogger(Bird.class);

    public static final String FLYING = "I am flying";
    public static final String SINGING = "I am singing";

    void fly() {
        LOG_JAVA.info(FLYING);
    }

    void sing() {
        LOG_JAVA.info(SINGING);
    }
}