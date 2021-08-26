import java.util.Scanner;

public class JavaIfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
			enterData();
	}
	private static void enterData() { //function to enter data
		Scanner scanner = new Scanner(System.in);
		boolean add;
		do {
			System.out.println("Ingresa un número seguido de la tecla enter:");
			String number =  scanner.next();
			add = isNumber(number); //To check if data entered is number, otherwise we cant proceed.
			if(add) {
				int numberX  =  Integer.parseInt(number);
				checkWeird(numberX);
			}else {
				System.out.println("Por favor asegurese de ingresar un número");
			}
		}while(!add);		
	}
	private static void checkWeird(int number) {
		if(!(number % 2 == 0)){ //if its not even, its odd
			System.out.println("Weird");
		}else if((number % 2 == 0) && (2 <= number && number <= 5)){
			System.out.println("Not Weird");
		}else if((number % 2 == 0) && (6 <= number && number <= 20)){
			System.out.println("Weird");
		}else if((number % 2 == 0) && (20 < number)){
			System.out.println("Not Weird");
		}
		repeat(); //ask user if wants to introduce another number
	}
	private static void repeat() { //function to repeat the program
		Scanner scanner = new Scanner(System.in);
		String answer;
		System.out.println("Quiere ingresar otro número?: (S/N)");
		answer = scanner.next().toUpperCase();
		if (answer.contentEquals("S")) {
			 enterData();
		}else {
			 System.out.println("Hasta pronto");
		}
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
