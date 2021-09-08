package javaStaticInitializerBlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Solution {
    private static final Logger logger = LogManager.getLogger(Solution.class.getName());

    private static Scanner scan = new Scanner(System.in);
    private static int base = scan.nextInt();
    private static int height = scan.nextInt();
    private static int upperLimit = 100;
    private static int lowerLimit = 0;

    public static void main(String[] args) {
        scan.close();
        try {
            if (Math.abs(base) > upperLimit ||
                    Math.abs(height) > upperLimit ||
                    (base <= lowerLimit) ||
                    (height <= lowerLimit)) {
                throw new Exception("Breadth and height must be positive");
            } else {
                logger.debug(base * height);
            }
        }
        catch(Exception e) {
            logger.error(e);
        }
    }
}
