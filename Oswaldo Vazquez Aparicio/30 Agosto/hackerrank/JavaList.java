package hackerrank;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class JavaList {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        
        int elementsNumber = scanner.nextInt();
        scanner.nextLine();
        
        fillLinkedList(elementsNumber);
        
        int queriesNumber = scanner.nextInt();
        scanner.nextLine();
        
        executeQueries(queriesNumber);
        
        printList();

        scanner.close();
        
    }
    
    private static void fillLinkedList(int elementsNumber){
        for(int elementIndex = 0; elementIndex < elementsNumber; elementIndex++){
            int element = scanner.nextInt();
            list.add(element);
        }
    }
    
    private static void executeQueries(int queriesNumber){
        for(int queryIndex = 0; queryIndex < queriesNumber; queryIndex++){
            String queryAction = scanner.next();
            executeAction(queryAction);
        }
    }
    
    private static void executeAction(String action){
        int index = scanner.nextInt();
        switch(action){
            case "Insert":
                int value = scanner.nextInt();
                list.add(index, value);
                break;
            case "Delete":
                list.remove(index);
                break;
            default:
                System.out.println("Action not available.");
        }
    }
    
    private static void printList(){
        for(int item: list){
            System.out.printf("%d ", item);
        }
    }

}