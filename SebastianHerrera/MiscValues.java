import java.util.Scanner;

public class MiscValues {

    /**
     * Print String, Double and Int values.
     */
    public static void getScanInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int i = scan.nextInt();
        System.out.print("Enter a double: ");
        double d = scan.nextDouble();
        System.out.print("Enter a message: ");
        String s = " ";
        s = scan.nextLine();
        s += scan.nextLine();
        scan.close();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
