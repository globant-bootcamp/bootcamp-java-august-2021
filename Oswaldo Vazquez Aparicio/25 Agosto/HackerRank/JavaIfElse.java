import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JavaIfElse {

    private static final String WEIRD = "Weird";
    private static final String NOT_WEIRD = "Not Weird";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if(isOdd(N))
            System.out.println(WEIRD);
        else if(!isOdd(N) && isBetweenRange(N, 2, 5))
            System.out.println(NOT_WEIRD);
        else if(!isOdd(N) && isBetweenRange(N, 6, 20))
            System.out.println(WEIRD);
        else if(!isOdd(N) && N > 20)
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