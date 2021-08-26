import java.io.*;
import java.util.*;

public class StdinAndStdoutI {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int[] a = new int[3];
        
        for (int i = 0; i<3; ++i)
            a[i] = scan.nextInt();    
        for (int i = 0; i<3; ++i)
            System.out.println(a[i]); 
        scan.close();
    }
}
