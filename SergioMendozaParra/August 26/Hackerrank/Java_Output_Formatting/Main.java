package java_output_formatting;

import java.util.Scanner;
import java.io.PrintStream;

public class Main {

    public static String addZeros(int number){
        String result;
        if(number >= 10 && number <= 99)
            result = "0" + number;
        else if(number >= 0 && number <= 9)    
            result = "00" + number;
        else
            result = "" + number;    
        
        return result;    
    } 

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            final int TOP = 3;
            final int BLANK_SPACES = 17;
            int number, counter;
            String string;
            System.out.println("================================");
            
            for(counter = 0; counter < TOP; counter++){
                string = scanner.next();
                number = scanner.nextInt();
                System.out.printf("%s %"+ (BLANK_SPACES - string.length()) +"s %n", string, addZeros(number));    
            }
            
            System.out.println("================================");

    }
}
