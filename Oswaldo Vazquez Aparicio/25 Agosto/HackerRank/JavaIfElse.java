package hackerrank;

import java.util.Scanner;

public class JavaIfElse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        final String WEIRD = "Weird";
        final String NOT_WEIRD = "Not Weird";

        if(isOdd(number)){
            System.out.println(WEIRD);
        }else{
            if(isBetweenRange(number, 2, 5)){
                System.out.println(NOT_WEIRD);
            }else if(isBetweenRange(number, 6, 20)){
                System.out.println(WEIRD);
            }else if(number > 20){
                System.out.println(NOT_WEIRD);
            }
        }

        scanner.close();
    }

    public static boolean isOdd(int number){
        return number % 2 != 0;
    }

    public static boolean isBetweenRange(int number, int min, int max){
        return number >= min && number <= max;
    }

}