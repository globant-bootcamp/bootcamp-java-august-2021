package bootcamp;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String string = input.next();

        if(palindromeCheck(string)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    public static boolean palindromeCheck(String string){
        boolean isPalindrome = true;
        for(int index = 0; index<string.length()/2; index++){
            if(string.charAt(index) != string.charAt(string.length()-1-index)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

}