package hackerrank3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
	static List<Integer> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		int elements = sc.nextInt();
		if(elements>=1 && elements<= 4000) {
			sc.nextLine();
			String[] values = sc.nextLine().split(" ");
			for(int i=0;i < elements;i++){
				list.add(Integer.parseInt(values[i]));
			}
			int queries = sc.nextInt();
			sc.nextLine();
			if(elements>=1 && elements<= 4000) {
				while(queries > 0){
					String querie = sc.next();
					sc.nextLine();
					Option(querie);
					queries--;
				}
			}else{
				System.out.println("Constraints: 1 <= Q <= 400");
			}
		}else{
			System.out.println("Constraints: 1 <= N <= 400");
		}
		for(Integer number : list) {
			System.out.print(number+" ");
		}
	}

	public static void Option(String option) {
		if(option.equals("Insert")) {
			String[] valuesxy = sc.nextLine().split(" ");
			list.add(Integer.parseInt(valuesxy[0]),Integer.parseInt(valuesxy[1]));
		}else if(option.equals("Delete")) {
			int index = sc.nextInt();
			list.remove(index);
		}
	}
}
