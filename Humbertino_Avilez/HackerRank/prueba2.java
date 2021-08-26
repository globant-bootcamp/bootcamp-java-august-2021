

import java.util.Scanner;

public class prueba2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero=sc.nextInt();
		if(numero%2==0) {
			if(numero>=2 && numero<=5) {
				System.out.print("Not Weird");
			}else if(numero>=6 && numero<=20) {
				System.out.print("Weird");
			}else if(numero>20) {
				System.out.print("Not Weird");
			}
		}else {
			System.out.print("Weird");
		}
		
		sc.close();
	}

}
