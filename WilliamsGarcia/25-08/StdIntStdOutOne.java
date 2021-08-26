import java.util.Scanner;

public class StdIntStdOutOne {
    public static void main(String[] args) {
        int cont = 0;
        Scanner scan = new Scanner(System.in);
        while (cont < 3) {
            cont++;
            System.out.println(scan.nextInt());
        }
        scan.close();
    }
}
