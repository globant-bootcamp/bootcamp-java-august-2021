package bootcamp.java.day.two.ifelse;

import java.util.Scanner;

public class JavaIfElse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int number = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (number % 2 == 1 || number >= 6 & number <= 20) {
            System.out.println("Weird");
        } else if (number > 20 || number >= 2 & number <= 5) {
            System.out.println("Not Weird");
        }

        scanner.close();
    }
}