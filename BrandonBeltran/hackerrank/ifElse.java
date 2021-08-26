package bootcamp;

import java.util.Scanner;

public class ifElse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();

        // Regex pattern provided by hackerrank, I'd rather not mess with it at this time.
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        /*
        *  If the number is odd or is in the inclusive range
        *  of 5 and 20, it's a weird number and the program should
        *  print "Weird", else, it should print "Not Weird".
        */
        if ((number > 5 && number < 21) || number % 2 == 1 ) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
    }
}
