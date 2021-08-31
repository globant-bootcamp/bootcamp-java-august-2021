package bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List <Integer> numbers = new ArrayList<>();

        for(int iterator = 0; iterator < size; iterator++){
            numbers.add(scanner.nextInt());
        }

        int queries = scanner.nextInt();

        for(int iterator = 0; iterator < queries; iterator++){
            String operation = scanner.next();
            int position = scanner.nextInt();

            if(operation.equals("Insert")){
                int addition = scanner.nextInt();
                numbers.add(position, addition);
            }else if (operation.equals("Delete")){
                numbers.remove(position);
            }
        }

        for(int index = 0; index < numbers.size(); index++){
            System.out.printf("%d ", numbers.get(index));
        }
    }
}
