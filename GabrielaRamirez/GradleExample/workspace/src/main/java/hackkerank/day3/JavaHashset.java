package hackkerank.day3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashset {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        String[] pair_left = new String[size];
        String[] pair_right = new String[size];

        for (int i = 0; i < size; i++) {
            pair_left[i] = scan.next();
            pair_right[i] = scan.next();
        }

        Set<String> pairs = new HashSet<String>(size);

        for (int i = 0; i < size; i++) {
            pairs.add("(" + pair_left[i] + ", " + pair_right[i] + ")");
            System.out.println(pairs.size());
        }
    }
}
