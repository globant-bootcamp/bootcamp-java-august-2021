package bootcamp;

import java.security.Permission;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class JavaIntToString {
    private static final Logger logger = LogManager.getLogger(Test.class);
    public static void main(String[] args) {

        DoNotTerminate.forbidExit();

        try {
            Scanner input = new Scanner(System.in);
            int number = input .nextInt();
            input.close();
            String s = String.valueOf(number);

            if (number == Integer.parseInt(s)) {
                logger.info("Good job");
            } else {
                logger.info("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            logger.info("Unsuccessful Termination!!");
        }
    }
}

class DoNotTerminate {
    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
