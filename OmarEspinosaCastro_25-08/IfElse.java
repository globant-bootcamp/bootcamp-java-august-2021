package globant25;

import java.util.Scanner;

public class IfElse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entero = scanner.nextInt();
        scanner.close();
        if (entero % 2 != 0) {
            System.out.println("Weird");
        } else if (entero >= 2 && entero <= 5) {
            System.out.println("Not Weird");
        } else if (entero >= 6 && entero <= 20) {
            System.out.println("Weird");
        } else if (entero > 20) {
            System.out.println("Not Weird");
        }
    }
}
