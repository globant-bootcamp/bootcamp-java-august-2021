import java.util.Scanner;

public class JavaIfElse {

    private static final String WEIRD = "Weird";
    private static final String NOT_WEIRD = "Not Weird";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if(isOdd(number))
            System.out.println(WEIRD);
        else if(!isOdd(number) && isBetweenRange(number, 2, 5))
            System.out.println(NOT_WEIRD);
        else if(!isOdd(number) && isBetweenRange(number, 6, 20))
            System.out.println(WEIRD);
        else if(!isOdd(number) && number > 20)
            System.out.println(NOT_WEIRD);

        scanner.close();
    }

    public static boolean isOdd(int number){
        return number % 2 != 0;
    }

    public static boolean isBetweenRange(int number, int min, int max){
        return number >= min && number <= max;
    }

}