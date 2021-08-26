import java.util.Scanner;

public class JavaIfElse {

	public static void main(String[] args) {
			enterData();
	}
	private static void enterData() { 
		Scanner scanner = new Scanner(System.in);
		boolean nextStep;
		do {
			System.out.println("Please enter a number and press Enter:");
			String number =  scanner.next();
			nextStep = isNumber(number);
			if(nextStep) {
				int numberX  =  Integer.parseInt(number);
				checkWeird(numberX);
			}else {
				System.out.println("Please make sure it is a number");
			}
		}while(!nextStep);		
	}
	private static void checkWeird(int number) {
		if(!(number % 2 == 0)){ 
			System.out.println("Weird");
		}else if((number % 2 == 0) && (2 <= number && number <= 5)){
			System.out.println("Not Weird");
		}else if((number % 2 == 0) && (6 <= number && number <= 20)){
			System.out.println("Weird");
		}else if((number % 2 == 0) && (20 < number)){
			System.out.println("Not Weird");
		}
		repeat(); 
	}
	private static void repeat() { 
		Scanner scanner = new Scanner(System.in);
		String answer;
		System.out.println("Want to try again?: (Y/N)");
		answer = scanner.next().toUpperCase();
		if (answer.contentEquals("Y")) {
			 enterData();
		}else {
			 System.out.println("See you later");
		}
	}
	static boolean  isNumber(String number) { 
		try {
			 Integer.parseInt(number);
			 return true;
		}catch(Exception e ){
			return false;
		}		
	}
	
}
