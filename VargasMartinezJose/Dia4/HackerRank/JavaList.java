package bootcamp.collections.com;

import java.io.*;
import java.util.*;

public class JavaList{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        List<Integer> integerList = new ArrayList<>();
        for(int index = 0; index<numberOfElements; index++){
            integerList.add(scanner.nextInt());
        }   
         int numberOfQueries = scanner.nextInt();
        for(int index = 0; index<numberOfQueries; index++){
            String word =scanner.next();
            if(word.equals("Insert")){
                int insertAtIndex = scanner.nextInt();
                int value = scanner.nextInt();
                integerList.add(insertAtIndex,value);
                 }
            if(word.equals("Delete")){
                int deleteAtIndex = scanner.nextInt();
                integerList.remove(deleteAtIndex);
               }
        }
    for (Integer integers : integerList){
        System.out.print(integers+" ");
              }
    }
}
