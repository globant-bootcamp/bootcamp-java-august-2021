import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if(number%2 == 1 || ( number > 6 && number <= 20 )){
            System.out.println("Weird");
        }else if( number > 2 && number < 5  || (number > 20)){
            System.out.println("Not Weird");
        }

        scanner.close();
        
    }
}
