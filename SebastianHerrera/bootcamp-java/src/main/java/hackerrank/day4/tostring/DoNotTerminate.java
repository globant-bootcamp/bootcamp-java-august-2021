package hackerrank.day4.tostring;

import java.security.Permission;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 01/09/21
 */
public class DoNotTerminate {

    public static final String EXIT_VM = "exitVM";

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains(EXIT_VM)) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1;
    }
}
