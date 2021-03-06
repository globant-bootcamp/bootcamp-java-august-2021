package bootcamp;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaStdinandStdoutII {
	public static String userString;
	public static int userInt;
	public static double userDouble; 
	public static String enter = ("Please enter a number and press Enter:");
	public static String error = ("Please make sure it is a number");
	public static void main(String[] args) {
		askInteger();
		askDouble();
		askString();
		printInputs();
	}

	private static void printInputs() {
		System.out.println("");
		System.out.println("String: " +userString);
		System.out.println("Double: " +userDouble);
		System.out.println("Int: " +userInt);
	}
	private static void askInteger() { 
		Scanner scanner = new Scanner(System.in);
		boolean nextStep;
		do {
			System.out.println(enter);
			String number =  scanner.next();
			nextStep = isNumber(number); 
			if(nextStep) {
				userInt = Integer.parseInt(number);	
			}else {
				System.out.println(error);
			}
		}while(!nextStep);	
	}
	private static void askString() { 
		Scanner scanner = new Scanner(System.in);
		System.out.println(enter);
		userString = scanner.next();
	}
	private static void askDouble() {
		Scanner scanner = new Scanner(System.in);
		boolean nextStep;
		do {
			System.out.println(enter);
			String number =  scanner.next();
			nextStep = isDouble(number); 
			if(nextStep) {
				userDouble = Double.parseDouble(number);	
			}else {
				System.out.println(error);
			}
		}while(!nextStep);	
		
	}
	static boolean  isNumber(String number) { 
		try {
			 Integer.parseInt(number);
			 return true;
		}catch(Exception e ){
			return false;
		}		
	}
	static boolean  isDouble(String number) { 
		String decimalPattern = "([0-9]*)\\.([0-9]*)";  
		String numberDouble = number;  
		boolean match = Pattern.matches(decimalPattern, number);
		return match;
	}
}
