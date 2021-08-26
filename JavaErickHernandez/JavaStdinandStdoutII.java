import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaStdinandStdoutII {
	public static String userString;
	public static int userInt;
	public static double userDouble; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		askInteger();
		askDouble();
		askString();
		printInputs();
	}

	private static void printInputs() {//function to print data in order
		System.out.println("");
		System.out.println("String ingresado: " +userString);
		System.out.println("Double ingresado: " +userDouble);
		System.out.println("Entero ingresado: " +userInt);
	}
	private static void askInteger() { //function to ask for the integer
		Scanner scanner = new Scanner(System.in);
		boolean add;
		do {
			System.out.println("Ingresa un número seguido de la tecla enter:");
			String number =  scanner.next();
			add = isNumber(number); //To check if data entered is number, otherwise we cant proceed.
			if(add) {
				userInt = Integer.parseInt(number);	
			}else {
				System.out.println("Por favor asegurese de ingresar un número");
			}
		}while(!add);	
	}
	private static void askString() { //everything with next is a string, no validation requiered.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa una cadena de texto seguido de la tecla enter:");
		userString = scanner.next();
	}
	private static void askDouble() {//function to ask for the double
		Scanner scanner = new Scanner(System.in);
		boolean add;
		do {
			System.out.println("Ingresa un número tipo double seguido de la tecla enter:");
			String number =  scanner.next();
			add = isDouble(number); //To check if data entered is number, otherwise we cant proceed.
			if(add) {
				userDouble = Double.parseDouble(number);	
			}else {
				System.out.println("Por favor asegurese de ingresar un número tipo double");
			}
		}while(!add);	
		
	}
	static boolean  isNumber(String number) { //function to determine if it is a number or not.
		try {
			 Integer.parseInt(number);
			 return true;
		}catch(Exception e ){
			return false;
		}		
	}
	static boolean  isDouble(String number) { //function to determine if it is a number double or not.
		String decimalPattern = "([0-9]*)\\.([0-9]*)";  
		String numberDouble = number;  
		boolean match = Pattern.matches(decimalPattern, number);
		return match;
	}
}
