package challenge;

import java.util.Scanner;

public class stdinAndStdoutI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[3];
        
        for (int index = 0; index<3; ++index)
            a[index] = scan.nextInt();    
        for (int index = 0; index<3; ++index)
            System.out.println(a[index]); 
        scan.close();
    }
}
