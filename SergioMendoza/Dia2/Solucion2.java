import java.io.*;
import java.util.*;

public class Solucion2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numero = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if(numero % 2 == 0){
            if(numero >= 6 && numero <= 20)
                System.out.println("Weird");
            else if(numero >= 2 && numero <= 5)
                System.out.println("Not Weird");
            else{
                System.out.println("Not Weird");
            }        
        }
        else
            System.out.println("Weird");    
        scanner.close();
    }
}

