package ChallengesOne;

import java.util.Scanner;

public class StdinStdout2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();
        double decimalNumber = scan.nextDouble();
        scan.nextLine();
        String text = scan.nextLine();
        scan.close();

        System.out.println("String: " + text);
        System.out.println("Double: " + decimalNumber);
        System.out.println("Int: " + number);
    }
}
