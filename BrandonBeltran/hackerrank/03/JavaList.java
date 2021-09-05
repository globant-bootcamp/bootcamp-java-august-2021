package bootcamp;

import java.util.ArrayList;
import java.util.Iterator;
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

            if(position <= numbers.size() || position < 0){
                switch(operation) {
                    case "Insert":
                        int addition = scanner.nextInt();
                        numbers.add(position, addition);
                        break;
                    case "Delete":
                        numbers.remove(position);
                        break;
                    default:
                        break;
                }
            }else{
                System.out.println("Error! Invalid position.");
            }
        }

        Iterator numbersIterator = numbers.iterator();
        while(numbersIterator.hasNext()){
            System.out.printf("%d ", numbersIterator.next());
        }
    }
}
