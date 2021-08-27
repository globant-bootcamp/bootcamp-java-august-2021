package bootcamp;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        /*
        * Easy and simple. A scanner that reads three
        * integers and then shows them back to you.
        */
        Scanner scan = new Scanner(System.in);
        int firstNumber = scan.nextInt();
        int secondNumber = scan.nextInt();
        int thirdNumber = scan.nextInt();

        scan.close();

        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println(thirdNumber);
    }
}