package bootcamp;

import java.util.HashSet;
import java.util.Scanner;

/* This solution is the one I came on my own without Hackerrank's code.
*  To be honest, I like it better, I include it for the sake of completion*/

public class JavaHashset {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sets = Integer.parseInt(scanner.nextLine());

        HashSet<String> names = new HashSet();

        for(int iterator = 0; iterator < sets; iterator++){
            names.add(scanner.nextLine());
            System.out.println(names.size());
        }

    }
}
