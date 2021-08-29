package myPackage;

import java.util.Scanner;

public class Main {

    public static String addZeros(int number){
        String result;
        if(number <= 99 && number >= 10)
            result = "0" + number;
        else if(number <= 9 && number >= 0)    
            result = "00" + number;
        else
            result = "" + number;    
        
        return result;    
    } 

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int     number, i;
            String  string;
            String  spaces = "";
            System.out.println("================================");
            
            for(i = 0; i < 3 ; i++){
                string = sc.next();
                number = sc.nextInt();
                spaces = String.format("%18s", addZeros(number));
                System.out.println(string + spaces.substring(string.length(), spaces.length()));    
            }
            
            System.out.println("================================");

    }
}
