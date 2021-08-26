import java.util.Scanner;

public class IfElse {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N <= 100 & N >= 1) {
            if (N % 2 == 0) {
                if (N >= 2 & N <= 5) {
                    System.out.println("Not Weird");
                } else if (N >= 6 & N <= 20) {
                    System.out.println("Weird");
                } else {
                    System.out.println("Not Weird");
                }
            } else {
                System.out.println("Weird");
            }
        }
        scanner.close();
    }
}
