package hackerrank;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

public class JavaStaticInitializerBlock {
	private static final Logger javaLog = Logger.getLogger(Main.class) ;
	static Scanner scanner = new Scanner(System.in);
	static final String MESSAGE_EXCEPTION ="java.lang.Exception: Breadth and height must be positive";
	static Boolean flag = false;
	static int numberOne, numberTwo;
	
	static {
		numberOne = scanner.nextInt();
		numberTwo = scanner.nextInt();
		if(numberOne < 0 || numberTwo < 0) {
			javaLog.error(MESSAGE_EXCEPTION);
		}else {
			flag = true;
		}
	}
	public static void main(String[] args) {
		if(flag) {
			int area = numberOne * numberTwo;
			javaLog.debug(area);
		}
	}
}
