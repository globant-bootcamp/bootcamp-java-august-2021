package bootcamp.hackerrank;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Solution {
	protected static final Scanner scanner = new Scanner(System.in);
	private static final String INPUT_INTEGER_INCORRECT = "Input must be a integer number";
	private static final String INPUT_BOUBLE_INCORRECT = "Input must be a double number";
  
  public abstract void solve();

  public static void closeScanner() {
    Solution.scanner.close();
  }
  
  protected static double readDoubleInput(String instruction) {
		double doubleInput;
		try {
			System.out.print(instruction);
			doubleInput = Solution.scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println(Solution.INPUT_BOUBLE_INCORRECT);
			Solution.scanner.nextLine();
			doubleInput = readDoubleInput(instruction);
		}
		return doubleInput;
	}
  
  protected static int readIntegerInput(String instruction) {
		int intInput;
		try {
			System.out.print(instruction);
			intInput = Solution.scanner.nextInt();
			Solution.scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println(Solution.INPUT_INTEGER_INCORRECT);
			Solution.scanner.nextLine();
			intInput = readIntegerInput(instruction);
		}
		return intInput;
	}
  
}
