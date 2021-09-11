import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public static final String COMPARE_STRING = "Insert";

public class Solution {

    public static void main(String[] args) {

        List<Integer> numberList=new ArrayList<Integer>();       
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();

        for(int index = 0; index < length; index++){

            String data = scan.next();
            int number=Integer.parseInt(data);
            numberList.add(number);  

        }
             
        int queryNumber = scan.nextInt();
    
        for(int index = 0; index < queryNumber; index++){

                String queryType = scan.next(); 
                                       
            if(queryType.compareTo(COMPARE_STRING)==0){
                int indexList = scan.nextInt();
                int value = scan.nextInt();
                numberList.add(indexList, Integer.valueOf(value));
            }else{                
                int indexDelete = scan.nextInt();               
                numberList.remove(indexDelete);
            }
        
        }
        
        scan.close();
        
        for(Integer number : numberList){
            System.out.print(number + " ");
        }
        
    }
    
}
