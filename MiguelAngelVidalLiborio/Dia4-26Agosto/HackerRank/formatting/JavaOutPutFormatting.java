package formatting;

import java.util.Scanner;

public class JavaOutPutFormatting {

	public static final Scanner SCANNER = new Scanner(System.in);
	public static final int LOOP_LIMIT = 3;

	public static void main(String[] args) {

		for (int index = 0; index < LOOP_LIMIT; index++) {
			String programmingLanguageScan = SCANNER.next();
			int numberScan = SCANNER.nextInt();

			System.out.printf("Programming Language: %-5s%03d\n", programmingLanguageScan, numberScan);
		}
	}

}
