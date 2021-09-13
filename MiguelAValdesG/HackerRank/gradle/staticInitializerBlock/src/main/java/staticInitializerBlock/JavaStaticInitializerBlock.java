package staticInitializerBlock;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class JavaStaticInitializerBlock {

  static final String BREADTH_AND_HEIGHT_MUST_BE_POSITIVE = "Breadth and height must be positive";
  static final String STATIC_INITIALIZER_BLOCK = "Java Static Initializer Block";

  static Logger log = Logger.getLogger(STATIC_INITIALIZER_BLOCK);
  static Scanner readLineTerminal = new Scanner(System.in);
  static int breadth = readLineTerminal.nextInt();
  static int height = readLineTerminal.nextInt();
  static boolean flag = true;

  static {
    try {
      if (breadth <= 0 || height <= 0) {
        flag = false;
        log.error(BREADTH_AND_HEIGHT_MUST_BE_POSITIVE);
        throw new Exception(BREADTH_AND_HEIGHT_MUST_BE_POSITIVE);
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
