package bootcamp.java.day.two.jsin;

import java.util.Scanner;

public class JavaStdinStdout1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int integerValue = scan.nextInt();
        int integerValue1 = scan.nextInt();
        int integerValue2 = scan.nextInt();

        System.out.println(integerValue);
        System.out.println(integerValue1);
        System.out.println(integerValue2);

        scan.close();
    }
}