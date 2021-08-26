package globant25;

import java.util.Scanner;

public class IfElse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        if (n % 2 != 0) {
            System.out.println("Weird");
        }
        if ((n >= 2 && n <= 5)&&(n % 2 == 0)) {
            System.out.println("Not Weird");
        }
        if ((n >= 6 && n <= 20)&&(n % 2 == 0)) {
            System.out.println("Weird");
        }
        if ((n > 20)&&(n % 2 == 0)) {
            System.out.println("Not Weird");
        }
    }
}
