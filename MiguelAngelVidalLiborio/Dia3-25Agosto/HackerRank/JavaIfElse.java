package hackerrank;

import java.util.Scanner;
public class JavaIfElse {

	public static void main(String[] args) {

		Scanner scanner =new Scanner(System.in);
		int number = scanner.nextInt();
		int isEven=number % 2;

		if(isEven ==0 && (number >=2 && number <=5) ){
			System.out.println("Not Weird");   

		}else if(isEven ==0 && (number >=6 && number <=20) || isEven ==1 ){
			System.out.println("Weird");     

		}else{
			System.out.println("Not Weird");   
		}
		scanner.close();
	}

}
