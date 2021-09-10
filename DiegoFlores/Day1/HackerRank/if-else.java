import java.util.Scanner;

public static final String WEIRD_NUMBER = "Weird";
public static final String NOT_WEIRD_NUMBER = "Not Weird";

public class Solution {

    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       int number = scanner.nextInt();
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       if(number%2 == 1 || ( number > 6 && number <= 20 )){
            System.out.println( WEIRD_NUMBER );
       }else{
            System.out.println( NOT_WEIRD_NUMBER );
       }
        
        scanner.close();
        
    }
}
