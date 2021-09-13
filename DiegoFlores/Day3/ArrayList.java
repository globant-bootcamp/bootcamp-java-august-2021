import java.io.Scanner;

public static final String ERROR_MESSAGE = "ERROR!"

public class ArrayList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int entriesNumber = sc.nextInt();
        String line = sc.nextLine();

        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>(entriesNumber);
        
        for (int index = 0; index < entriesNumber; index++) {

            line = sc.nextLine();
        
            String[] splitLine = line.split(" ");                        
            
            listOfLists.add(index, new ArrayList<String>(Arrays.asList(splitLine)));
           
        }
        
        int queryesNumber = sc.nextInt();
       
        for (int index = 0; index < queryesNumber; index++) {

            int fisrtElement = sc.nextInt();
            int secondElement = sc.nextInt();
            
            if(fisrtElement <= listOfLists.size() && secondElement < listOfLists.get(fisrtElement -1).size()  && secondElement >= 0){
               System.out.println(listOfLists.get(fisrtElement-1).get(secondElement));
            }else{
                System.out.println(ERROR_MESSAGE);
            }
            
        }
        
  
    }
    
}