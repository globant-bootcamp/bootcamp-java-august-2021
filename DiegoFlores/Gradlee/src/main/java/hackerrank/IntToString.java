package hackerrank;

import java.util.Scanner;

public class IntToString {
	
	public static void main(String[] args) {

	
		  try {
		   Scanner in = new Scanner(System.in);
		   int inputNumber = in .nextInt();
		   in.close();
		 
		    String stringNumber = Integer.toString(inputNumber);
		   
		   if (inputNumber == Integer.parseInt(stringNumber)) {
		    System.out.println("Good job");
		   } else {
		    System.out.println("Wrong answer.");
		   }
		  } catch (Exception e) {
		   System.out.println("Unsuccessful Termination!!");
		  }
		 }
	
	
	
}
