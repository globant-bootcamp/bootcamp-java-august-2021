
package collection;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Map {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lengthDirectory = in.nextInt();
        in.nextLine();
        Map<String, Integer> directoryMap = new HashMap<>();
        for (int rowDirectory = 0; rowDirectory < lengthDirectory; rowDirectory++) {
            String keyName = in.nextLine();
            int valueNumber = in.nextInt();
            directoryMap.put(keyName, valueNumber);
            in.nextLine();
        }
        String findUser = in.nextLine();
        while (!findUser.equals("")) {
            if(directoryMap.containsKey(findUser)){
                System.out.println(findUser+"="+directoryMap.get(findUser));
            }else{
                System.out.println("Not found");
            }
            findUser = in.nextLine();
        }
    }
}
