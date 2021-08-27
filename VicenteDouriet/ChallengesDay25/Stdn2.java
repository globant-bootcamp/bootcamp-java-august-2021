import java.io.*;
import java.util.*;

public class Stdn2 {

    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);
        
        int myInt = scanner.nextInt();
        double myDouble = scanner.nextDouble();
        scanner.nextLine();
        String myString = scanner.nextLine();
        
        scanner.close();
        
        System.out.println("String: " + myString);
        System.out.println("Double: " + myDouble);
        System.out.println("Int: " + myInt);
        
    }
}