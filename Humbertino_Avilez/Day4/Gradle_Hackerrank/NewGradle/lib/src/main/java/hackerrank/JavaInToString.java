package hackerrank;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sun.tools.javac.Main;

public class JavaInToString {
	private static Logger javaLog = Logger.getLogger(Main.class);
	static Scanner scanner = new Scanner(System.in);
	static final String MESSAGE_SUCCESFULLY = "Good job";
	static final String MESSAGE_FAIL = "Wrong answer";
	
	public static void main(String[] args) {
		try {
			String.valueOf(scanner.nextInt());
			javaLog.debug(MESSAGE_SUCCESFULLY);
		}catch(Exception exception) {
			javaLog.error(MESSAGE_FAIL);
		}

	}

}
