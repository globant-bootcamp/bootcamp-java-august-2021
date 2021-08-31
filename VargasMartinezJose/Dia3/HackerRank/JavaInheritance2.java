package bootcamp.java.day.three.jinh2;

import java.util.Scanner;

public class JavaInheritance2 {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int integerValue = scan.nextInt();
        double doubleValue = scan.nextDouble();
        scan.nextLine();
        String stringValue = scan.nextLine();

        System.out.println("String: " + stringValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Int: " + integerValue);

    }
}
