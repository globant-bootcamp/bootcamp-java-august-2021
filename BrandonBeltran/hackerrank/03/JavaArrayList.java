package bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArrayList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int collections = scanner.nextInt();
        ArrayList <List> numbers = new ArrayList<>();

        for(int collectionIterator = 0; collectionIterator < collections; collectionIterator++){
            int size = scanner.nextInt();

            ArrayList <Integer> numberSubList = new ArrayList<>();

            int listIterator = 0;
            while(listIterator < size){
                numberSubList.add(scanner.nextInt());
                listIterator++;
            }
            numbers.add(numberSubList);
        }
        int queries = scanner.nextInt();

        for(int iterator = 0; iterator < queries; iterator++){
            int collection = scanner.nextInt()-1;
            int index = scanner.nextInt()-1;

            if( numbers.size() <= collection || numbers.get(collection).size() <= index){
                System.out.println("ERROR!");
            }else{
                System.out.println(numbers.get(collection).get(index));
            }
        }

    }
}
