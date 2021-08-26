package clasesPruebas;
import java.util.Scanner;

public class TestStdinStdout2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		double decimal = sc.nextDouble();
		String word = sc.next();
		System.out.println("String: " + word);
		System.out.println("Double: " + decimal);
		System.out.println("Int: " + number);
		sc.close();
	}
}
