import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        int t = scann.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = scann.next();
            pair_right[i] = scann.next();
        }

        HashSet<String> hashSet = new HashSet<>();

        for(int index = 0; index < t; index++){
            hashSet.add(pair_left[index]+" "+pair_right[index]);
            System.out.println(hashSet.size());
        }

    }

}