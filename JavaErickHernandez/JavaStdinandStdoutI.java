import java.util.Scanner;

public class JavaStdinandStdoutI {
	public static int data [] = new int [3];
	public static void main(String[] args) {
		enterData();
		printData();
	}
	
	private static void printData() { 
		for(int i = 0; i < data.length; i++) {
			System.out.println("");
			System.out.println("Number "+(i+1)+" introduced: " +data[i]);
			System.out.println("");
		}
	}
	static void enterData() {
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		do {
			System.out.println("Please enter a number and press Enter:");
			String number =  scanner.next();
			boolean nextStep = isNumber(number);
			if(nextStep) { 
				data[counter] = Integer.parseInt(number);
				counter++;
			}else {
				System.out.println("Please make sure it is a number");
			}
		}while(counter <= 2);
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
