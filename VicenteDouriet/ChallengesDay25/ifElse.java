import java.io.*;
import java.util.*;

public class ifElse {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        
	scanner.close();
        if((input % 2 != 0)  || (input % 2 == 0 && (input > 5 && input <21 ))){
            System.out.println("Weird");
            
        } else {
            System.out.println("Not Weird");
        }
        
    }
}