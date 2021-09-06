package staticInitializerBlock;

import java.util.Scanner;
import org.apache.log4j.Logger;

public class JavaStaticInitializerBlock {

  static Logger log = Logger.getLogger("Java Static Initializer Block");
  static Scanner readLineTerminal = new Scanner(System.in);
  static int breadth = readLineTerminal.nextInt();
  static int height = readLineTerminal.nextInt();
  static boolean flag = true;
  static {
    try {
      if (breadth <= 0 || height <= 0) {
        flag = false;
        log.error("Breadth and height must be positive");
        throw new Exception("Breadth and height must be positive");
      }
    } catch (Exception e) {
      log.fatal(e.getMessage());
    }
  }

  public static void main(String[] args) {
    if (flag) {
      int area = breadth * height;
      log.info(area);
    }
  }

}
