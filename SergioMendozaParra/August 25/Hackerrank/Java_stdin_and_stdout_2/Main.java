package myPackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);    
        int integer_number = scan.nextInt();
        double double_number = scan.nextDouble();
        String string = scan.nextLine(); 
        string = scan.nextLine();
        
        System.out.println("String: " + string);
        System.out.println("Double: " + double_number);
        System.out.println("Int: " + integer_number);
    }
}
