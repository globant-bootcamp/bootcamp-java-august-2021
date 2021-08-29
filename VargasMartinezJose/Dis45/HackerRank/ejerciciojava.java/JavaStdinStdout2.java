import java.util.Scanner;

public class JavaStdinStdout2{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int ineteger_value = scan.nextInt();
        double double_value = scan.nextDouble();
        scan.nextLine();
        String string_value = scan.nextLine();
        

        System.out.println("String: "+ string_value);
        System.out.println("Double: " + double_value);
        System.out.println("Int: " + ineteger_value);
       
        
        scan.close();
        
    }
}
