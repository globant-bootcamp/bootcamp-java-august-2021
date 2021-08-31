package hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pairsNumber = scanner.nextInt();

        HashSet<String> pairs = new HashSet<>();

        for (int index = 0; index < pairsNumber; index++) {
            String leftPair = scanner.next();
            String rightPair = scanner.next();

            String currentPair = String.format("%s %s", leftPair, rightPair);
            pairs.add(currentPair);

            int currentUniquePairsNumber = pairs.size();

            System.out.println(currentUniquePairsNumber);

        }

    }
    
}