import java.util.Scanner;

public class JavaStdinStdout1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int integer_a = scan.nextInt();
        int integer_b = scan.nextInt();
        int integer_c = scan.nextInt();

        System.out.println(integer_a);
        System.out.println(integer_b);
        System.out.println(integer_c);

        scan.close();
    }
}