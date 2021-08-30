package outputFormatting;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String defString = "================================";
        Scanner sc = new Scanner(System.in);
        System.out.println(defString);
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();

            System.out.printf("%-14s %03d%n", s1, x);
        }

        sc.close();
        System.out.println(defString);
    }
}
