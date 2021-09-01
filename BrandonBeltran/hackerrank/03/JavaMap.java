package bootcamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

    public static void main(String[] args) {

        Map<String, Integer> phoneBook = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());
        for(int iterator = 0; iterator < queries; iterator++){

            String name = scanner.nextLine();
            int number = Integer.parseInt(scanner.nextLine());
            phoneBook.put(name, number);

        }

        while(scanner.hasNext()){
            String query = scanner.nextLine();
            if(phoneBook.containsKey(query)){
                int number = phoneBook.get(query);
                System.out.printf("%s=%d%n",query,number);
            }else{
                System.out.println("Not found");
            }
        }

    }
}
