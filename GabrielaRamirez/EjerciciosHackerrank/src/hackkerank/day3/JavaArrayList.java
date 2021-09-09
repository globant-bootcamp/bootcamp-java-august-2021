package hackkerank.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JavaArrayList {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();

        List[] set = new ArrayList[lines];
        for (int i = 0; i < lines; i++) {
            int size = in.nextInt();
            set[i] = new ArrayList();
            for (int j = 0; j < size; j++) {
                set[i].add(in.nextInt());
            }
        }
        int queryNumber = in.nextInt();
        for (int i = 0; i < queryNumber; i++) {
            int position = in.nextInt();
            int line = in.nextInt();
            try {
                System.out.println(set[position - 1].get(line - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
        in.close();
    }
}
