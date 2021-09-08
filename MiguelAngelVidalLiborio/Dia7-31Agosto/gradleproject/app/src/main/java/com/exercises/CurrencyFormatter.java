package com.exercises;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

	public static final Scanner SCAN = new Scanner(System.in);
	public static final Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		double payment = SCAN.nextDouble();
		SCAN.close();

		String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
		String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
		String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
		String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

		log.debug(String.format("US: %s\n", us));
		log.debug(String.format("India: %s\n", india));
		log.debug(String.format("China: %s\n", china));
		log.debug(String.format("France: %s\n", france));
	}

}
