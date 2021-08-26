package nao.example.inout_2;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int printedInt = scan.nextInt();
        double printedDouble = scan.nextDouble();
        scan.nextLine();
        String printedString = scan.nextLine();
        

        System.out.println("String: " + printedString);
        System.out.println("Double: " + printedDouble);
        System.out.println("Int: " + printedInt);
    }
}