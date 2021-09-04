package hackerrank;

import java.util.Scanner;

public static final String GOOD_JOB  = "Good job";
public static final String WRONG_ANSWER = "Wrong answer.";
public static final String ERROR = "Unsuccessful Termination!!";

public class IntToString {
	
	public static void main(String[] args) {
		
		try {
		   
			Scanner in = new Scanner(System.in);
		   	int inputNumber = in .nextInt();
		   	in.close();		 
		   	String stringNumber = Integer.toString(inputNumber);
		   
		   	if (inputNumber == Integer.parseInt(stringNumber)) {
		    		System.out.println(GOOD_JOB);
		   	} else {
		    		System.out.println(WRONG_ANSWER);
		  	}
		
		    } catch (Exception e) {
		   	System.out.println(ERROR);
		    }
	}
	
}
