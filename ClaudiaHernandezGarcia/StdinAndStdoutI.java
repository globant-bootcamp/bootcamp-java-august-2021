import java.util.Scanner;
public class stdinAndStdoutI {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int[] a = new int[3];
        
        for (int index = 0; index<3; ++index)
            a[index] = scan.nextInt();    
        for (int index = 0; index<3; ++index)
            System.out.println(a[index]); 
        scan.close();
    }
}
