package javaIntToString;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Solution {
    private static final Logger logger = LogManager.getLogger(javaStaticInitializerBlock.Solution.class.getName());

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int numberEntered = scan.nextInt();
            System.out.println(numberEntered);
            scan.close();

            String str = Integer.toString(numberEntered);
            logger.debug("Good job");

            throw new Exception();
        } catch(Exception e) {
            logger.error("Wrong answer");
        }
    }
}
