package JavaMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> phoneDirectory = new HashMap<>();

        int directorySize = in.nextInt();
        in.nextLine();

        for(int index=0; index < directorySize; index++){
            String name = in.nextLine();
            int phone=in.nextInt();
            phoneDirectory.put(name, phone);
            in.nextLine();

        }

        while(in.hasNext())
        {
            String searchName=in.nextLine();
            if(phoneDirectory.containsKey(searchName)){
                System.out.println(searchName +"="+ phoneDirectory.get(searchName));
            }
            else{
                System.out.println("Not found");
            }
        }
    }
}
