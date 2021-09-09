package com.exercises;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import java.util.Scanner;

public class StaticInitializerBlock {

	public static final Logger log = Logger.getLogger(Main.class);
	public static final Scanner SCAN = new Scanner(System.in);
	public static final String messageException = "Breadth and height must be positive";
	public static int parallelogramBreadth, parallelogramHeight;
	public static boolean valid = true;

	static {
		parallelogramBreadth = SCAN.nextInt();
		parallelogramHeight = SCAN.nextInt();
		SCAN.close();
		try {
			if (parallelogramBreadth <= 0 || parallelogramHeight <= 0) {
				valid = false;
				throw new Exception(messageException);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public static void main(String[] args) {
		if (valid) {
			int area = parallelogramBreadth * parallelogramHeight;
			log.debug(area);
		}
	}
}
