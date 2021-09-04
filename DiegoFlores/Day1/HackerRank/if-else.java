import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String WEIRD_NUMBER = "Weird";
    public static final String NOT_WEIRD_NUMBER = "Not Weird";

    public static void main(String[] args) {
        
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
