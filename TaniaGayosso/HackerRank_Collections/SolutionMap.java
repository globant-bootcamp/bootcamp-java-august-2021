package challenges.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionMap {

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		int contacts = scanner.nextInt();
		scanner.nextLine();
		Map<String, Integer> myDirectory = new HashMap<>();
		for (int i = 0; i < contacts; i++) {
			String name = scanner.nextLine();
			int phone = scanner.nextInt();
			myDirectory.put(name, phone);
			scanner.nextLine();
		}
		while (scanner.hasNext()){
			String queries = scanner.nextLine();
			if (myDirectory.containsKey(queries)){
				System.out.println(queries + "=" + myDirectory.get(queries));
			}else{
				System.out.println("Not found");
			}
		}
		scanner.close();
	}
}
