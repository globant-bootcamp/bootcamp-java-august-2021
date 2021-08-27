package globant25;

import java.util.Scanner;

public class Conditional {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        if ((n % 2 != 0) || (((n >= 6 && n <= 20)) && (n % 2 == 0))) {
            System.out.println("Weird");
        }else{
            System.out.println("No Weird");
        }
    }
}
