package bootcamp;

import java.util.Scanner;

public class scannerTest {

    public static void main(String[] args) {
        /*
        * Easy and simple. A scanner that reads three
        * integers and then shows them back to you.
        */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        scan.close();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}