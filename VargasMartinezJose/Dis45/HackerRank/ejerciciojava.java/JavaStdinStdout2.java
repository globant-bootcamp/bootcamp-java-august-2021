package bootcamp.java.day.two.jsin2;

import java.util.Scanner;

public class JavaStdinStdout2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inetegerValue = scan.nextInt();
        double doubleValue = scan.nextDouble();
        scan.nextLine();
        String stringValue = scan.nextLine();

        System.out.println("String: " + stringValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Int: " + inetegerValue);

        scan.close();

    }
}
