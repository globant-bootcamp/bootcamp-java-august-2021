package globant25;

import java.util.Scanner;

public class Conditional {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberIn = scanner.nextInt();
        scanner.close();
        if ((numberIn % 2 != 0) || (((numberIn >= 6 && numberIn <= 20)) && (numberIn % 2 == 0))) {
            System.out.println("Weird");
        }else{
            System.out.println("No Weird");
        }
    }
}
