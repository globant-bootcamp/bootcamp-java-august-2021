package bootcamp;

import java.util.Scanner;

public class OutputFormatting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        for(int iterations = 0; iterations < 3; iterations++){
            String string = scanner.next();
            int number = scanner.nextInt();
            System.out.printf("%-15s%03d%n", string, number);
        }
        System.out.println("================================");
    }
}
