package globant25;

import java.util.Scanner;

public class StdinStdout2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entero = scanner.nextInt();
        double doble = scanner.nextDouble();
        scanner.nextLine();
        String cadena = scanner.nextLine();
        scanner.close();
        System.out.println("String: " + cadena);
        System.out.println("Double: " + doble);
        System.out.println("Int: " + entero);
    }
}
