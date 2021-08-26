package globant25;

import java.util.Scanner;

public class StdinStdout1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int enteroUno = scanner.nextInt();
        int enteroDos = scanner.nextInt();
        int enteroTres = scanner.nextInt();
        scanner.close();
        System.out.println(enteroUno);
        System.out.println(enteroDos);
        System.out.println(enteroTres);
    }

}
