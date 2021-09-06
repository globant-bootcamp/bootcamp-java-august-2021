package hackerrank3;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashset {
	static HashSet<String> pairs = new HashSet<String>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int elements = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < elements; i++){
			String name = sc.nextLine();
			pairs.add(name);
			System.out.println(pairs.size());
		}
		sc.close();
	}
}
