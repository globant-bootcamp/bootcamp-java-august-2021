import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        String operationResult;
        int number = scanner.nextInt();
       
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       if(number%2 == 1 || ( number > 6 && number <= 20 )){
            operationResult = "Weird";
       }else{
            operationResult = "Not Weird";
       }
        
        System.out.println(operationResult);

        scanner.close();
        
    }
}
