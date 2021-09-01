package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pairsNumber = scanner.nextInt();

        Set<String> pairsSet = new HashSet<>();

        for (int index = 0; index < pairsNumber; index++) {
            String leftPair = scanner.next();
            String rightPair = scanner.next();

            String currentPair = String.format("%s %s", leftPair, rightPair);
            pairsSet.add(currentPair);

            int currentUniquePairsNumber = pairsSet.size();

            System.out.println(currentUniquePairsNumber);

        }

    }
    
}