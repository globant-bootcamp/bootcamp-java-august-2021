import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        for(int i = 0; i<3; i++){
            String s = scanner.next();
            int myInt = scanner.nextInt();
            System.out.printf("%-15s%03d\n", s, myInt);
        }
        System.out.println("================================");
        
    }
}