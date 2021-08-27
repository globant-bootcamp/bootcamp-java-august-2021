package hackerrank;

import java.util.Scanner;

public class JavaOutPutFormatting {

	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int limitLoop=3;
		
		System.out.println("please enter your programming language and how much you love it");
		System.out.println("================================");
		for (int index = 0; index < limitLoop; index++) {
			String programmingLanguageScan = scanner.next();
			int numberScan = scanner.nextInt();

			System.out.printf("%-5s%03d\n", programmingLanguageScan, numberScan);
		}
		System.out.println("================================");
	}

}
