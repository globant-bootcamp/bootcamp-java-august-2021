import java.util.Scanner;

public class SolutionPrintf {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String equalsInALine = "================================"
        System.out.println(equalsInALine);
        for (int i = 0; i < 3; i++) {
            String s = scanner.next();
            int myInt = scanner.nextInt();
            System.out.printf("%-15s%03d\n", s, myInt);
        }
        System.out.println(equalsInALine);

    }
}