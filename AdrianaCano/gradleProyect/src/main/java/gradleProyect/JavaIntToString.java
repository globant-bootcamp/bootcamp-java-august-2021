package gradleProyect;

import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static gradleProyect.JavaIntToString.LOGGER;

public class JavaIntToString {
final static Log LOGGER = LogFactory.getLog(Main.class);
    public static void IntToString() {
        try {
            Scanner sc = new Scanner(System.in);
            int numAsInt = sc.nextInt();
            String numAsString = String.valueOf(numAsInt);
            if (numAsInt<=100 && numAsInt>= -100 && numAsInt == Integer.parseInt(numAsString)) {
                LOGGER.info("Good job");
            } else {
                LOGGER.info("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            LOGGER.info("Unsuccessful Termination!!");
        }
    }
}

