import java.util.Scanner;

public class JavaStdinandStdoutII {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int integerNum = scan.nextInt();
        double doubleNum = scan.nextDouble();
        scan.nextLine();
        String string = scan.nextLine();
        
        scan.close();

        System.out.println("String: " + string);
        System.out.println("Double: " + doubleNum);
        System.out.println("Int: " + integerNum);
    }
    
}