package clasesPruebas;
import java.util.Scanner;

public class prueba3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int entero = sc.nextInt();
		double doble = sc.nextDouble();
		String cadena = sc.next();

		System.out.println("String: " + cadena);
		System.out.println("Double: " + doble);
		System.out.println("Int: " + entero);
		sc.close();
	}
}
