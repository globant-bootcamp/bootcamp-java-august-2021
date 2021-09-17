package gradleProyect;

import static gradleProyect.JavaIntToString.LOGGER;
import java.util.Scanner;

public class StaticInitializerBlock {

    static boolean flag = false;
    static int base = 0;
    static int height = 0;
    static int area = 0;   

    public static void StaticInitializerBlock() {
        Scanner scanner = new Scanner(System.in);
        base = scanner.nextInt();
        height = scanner.nextInt();
        try {
            if (base > 0 && height > 0) {
                LOGGER.info(base * height);
            } else {
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }

    }
}
