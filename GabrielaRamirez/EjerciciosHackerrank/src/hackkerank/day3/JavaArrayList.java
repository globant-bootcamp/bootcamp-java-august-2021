package hackkerank.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaArrayList {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();

        ArrayList[] set = new ArrayList[lines];
        for(int i=0;i<lines;i++){
            int size = in.nextInt();
            set[i] = new ArrayList();
            for(int j=0;j<size;j++){
                set[i].add(in.nextInt());
            }
        }
        int queryNumber=in.nextInt();
        for(int i=0;i<queryNumber;i++){
            int position=in.nextInt();
            int line=in.nextInt();
            try{
                System.out.println(set[position-1].get(line-1));
            } catch(Exception e){
                System.out.println("ERROR!");
            }
        }
        in.close();
    }
}
