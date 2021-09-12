package bootcamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class JavaList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List <Integer> numberList = new ArrayList<>();

        for(int iterator = 0; iterator < size; iterator++){
            numberList.add(scanner.nextInt());
        }

        int queries = scanner.nextInt();

        for(int iterator = 0; iterator < queries; iterator++){
            String operation = scanner.next();
            int position = scanner.nextInt();

            if(position <= numberList.size() || position < 0){
                switch(operation) {
                    case "Insert":
                        int addition = scanner.nextInt();
                        numberList.add(position, addition);
                        break;
                    case "Delete":
                        numberList.remove(position);
                        break;
                    default:
                        break;
                }
            }else{
                System.out.println("Error! Invalid position.");
            }
        }

        Iterator numberListIterator = numberList.iterator();
        while(numberListIterator.hasNext()){
            System.out.printf("%d ", numberListIterator.next());
        }
    }
}
