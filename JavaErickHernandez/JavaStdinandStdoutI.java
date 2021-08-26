import java.util.Scanner;

public class JavaStdinandStdoutI {
	public static int data [] = new int [3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Se ingresarán a continuación tres números.");
		enterData();
		printData();
	}
	
	private static void printData() { //function to print data as instructions ask.
		// TODO Auto-generated method stub
		for(int i = 0; i < data.length; i++) {
			System.out.println("");
			System.out.println("Número "+(i+1)+" ingresado: " +data[i]);
			System.out.println("");
		}
	}
	static void enterData() { // function to enter data
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		do {
			System.out.println("Ingresa un número seguido de la tecla enter:");
			String number =  scanner.next();
			boolean add = isNumber(number); //To check if data entered is number, otherwise we cant proceed.
			if(add) { 
				data[counter] = Integer.parseInt(number);
				counter++;
			}else {
				System.out.println("Por favor asegurese de ingresar un número");
			}
		}while(counter <= 2);
	}
	static boolean  isNumber(String number) { //function to determine if it is a number or not.
		try {
			 Integer.parseInt(number);
			 return true;
		}catch(Exception e ){
			return false;
		}		
	}
}
