package challenges.collections;

import java.io.*;
import java.util.*;

public class SolutionArrayList {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int lines = scanner.nextInt();
		List[] myArrayList = new ArrayList[lines];
		
		for (int i = 0; i < lines; i++){
			int size = scanner.nextInt();
			myArrayList[i] = new ArrayList();
			
		for (int j = 0; j < size; j++){
			int items = scanner.nextInt();
			myArrayList[i].add(items);
			}
		}

		int queries = scanner.nextInt();

		for (int index = 0; index < queries; index++) {
			int xPosition = scanner.nextInt();
			int yPosition = scanner.nextInt();

			try {
				System.out.println(myArrayList[xPosition - 1].get(yPosition - 1));
			} catch (Exception e) {
				System.out.println("ERROR!");
			}
		}
		scanner.close();
	}
}