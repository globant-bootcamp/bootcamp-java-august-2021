package gradleProyect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;


public class Main {

    final static Log LOGGER = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        LOGGER.info("Hey, we are using a log instead of a System.out.print");
        JavaIntToString.IntToString();
        CurrencyFormatter.CurrencyFormatter();
        StaticInitializerBlock.StaticInitializerBlock();
    }
}
