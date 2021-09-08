package bootcamp.java.day.three.jouf;

import java.util.Scanner;

public class JavaOutputFormatting {
    public static final Scanner scan = new Scanner(System.in);
    public static final String LINES = "================================";
    public static final String FORMATSYNTAX = "%-15s%03d%n";
    public static void main(String[] args) {
        int upperRange = 3;
        System.out.println(LINES);
        for (int index = 0; index < upperRange; index++) {
            String stringsValue = scan.next();
            int integersValue = scan.nextInt();
            System.out.printf(FORMATSYNTAX,stringsValue, integersValue);
        }
        System.out.println(LINES);
     }
}
