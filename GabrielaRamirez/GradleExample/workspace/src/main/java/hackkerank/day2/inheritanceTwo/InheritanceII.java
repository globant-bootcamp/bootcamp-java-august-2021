package hackkerank.day2.inheritanceTwo;

import hackkerank.day1.IfElse;
import org.apache.log4j.Logger;

public class InheritanceII{

    public static Logger logJava = Logger.getLogger(InheritanceII.class);

        public static void main(String []args){

            Adder a = new Adder();
            logJava.info("My superclass is: " + a.getClass().getSuperclass().getName());

            logJava.info(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
        }
}
