package HashSet;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class HashSetResult {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numOfItems = in.nextInt();

        String[] pairLeft = new String[numOfItems];
        String[] pairRight = new String[numOfItems];

        for (int index = 0; index < numOfItems; index++) {
            pairLeft[index] = in.next();
            pairRight[index] = in.next();
        }

        Set<String> pairsSet = new HashSet<>();

        for (int counterPair = 0; counterPair < numOfItems; counterPair++) {
            pairsSet.add(pairLeft[counterPair] + "," + pairRight[counterPair]);
            System.out.println(pairsSet.size());
        }
    }
}
