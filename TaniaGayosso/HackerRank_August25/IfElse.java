import java.util.Scanner;

public class IfElse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	
        int n = scanner.nextInt();
        String message = "";
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if (n % 2 == 1){
                message="Weird";
        }else{
            if(n >= 2 && n <= 5){
                 message="Not Weird";
            }else if(n >= 6 && n <= 20){
                message="Weird";
            }else{
                message="Not Weird";
            }
        }
        scanner.close();
        System.out.println(message);
    }
}
