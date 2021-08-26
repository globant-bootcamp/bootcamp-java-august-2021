package clasesPruebas;

import java.util.Scanner;

public class prueba2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number=sc.nextInt();

		if(number%2==0) {
			if(number>=2 && number<=5 || number>20 ) {
				System.out.print("Not Weird");
			}else if(number>=6 && number<=20) {
				System.out.print("Weird");
			}
		}else {
			System.out.print("Weird");
		}
		sc.close();
	}

}
