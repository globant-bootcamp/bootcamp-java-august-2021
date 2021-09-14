package hackkerank.day2.inheritanceTwo;

import org.apache.log4j.Logger;

public class InheritanceII{

    public static Logger LOG_JAVA = Logger.getLogger(InheritanceII.class);

    public static final String SUPPER_CLASS = "My superclass is: ";
    public static final String SPACE = " ";

        public static void main(String []args){

            Adder a = new Adder();
            LOG_JAVA.info(SUPPER_CLASS + a.getClass().getSuperclass().getName());
            LOG_JAVA.info(a.add(10,32) + SPACE + a.add(10,3) + SPACE + a.add(10,10) + "\n");
        }
}
