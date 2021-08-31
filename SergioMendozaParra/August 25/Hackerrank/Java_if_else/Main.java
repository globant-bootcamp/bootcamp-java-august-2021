package myPackage;

import java.util.Scanner;

public class Main {

    private static final String[] ANSWER = {"Weird", "Not Weird"};

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(((number % 2 == 0 && number >= 2 && number <= 5) || (number % 2 == 0 && number >= 21)?ANSWER[0]:ANSWER[1]));
        scanner.close();
    }
}

