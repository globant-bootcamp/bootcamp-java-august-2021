package hackkerank.day3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashset {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = scan.next();
            pair_right[i] = scan.next();
        }

        Set<String> pairs = new HashSet<String>(t);

        for (int i = 0; i < t; i++) {
            pairs.add("(" + pair_left[i] + ", " + pair_right[i] + ")");
            System.out.println(pairs.size());
        }
    }
}
