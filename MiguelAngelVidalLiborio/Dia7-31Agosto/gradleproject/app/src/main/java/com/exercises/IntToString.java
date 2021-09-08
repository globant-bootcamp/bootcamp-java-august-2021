package com.exercises;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import java.util.Scanner;

public class IntToString {

	public static final Logger log = Logger.getLogger(Main.class);
	public static final Scanner SCAN = new Scanner(System.in);
	public static final String GOOD_JOB = "Good job.";
	public static final String WRONG_ANSWER = "Wrong answer.";

	public static void main(String[] args) {
		int numberTerminalScan = SCAN.nextInt();
		SCAN.close();

		String numberConvertedToString = Integer.toString(numberTerminalScan);

		if (numberTerminalScan == Integer.parseInt(numberConvertedToString)) {
			log.debug(GOOD_JOB);
		} else {
			log.debug(WRONG_ANSWER);
		}
	}
}