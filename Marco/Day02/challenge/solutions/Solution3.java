package challenge.solutions;

import challenge.Main;

public class Solution3 {

    public void thirdSolution() {

        System.out.println("Enter an Integer below:");
        int user_integer = Main.scan.nextInt();
        System.out.println("Enter a Double below:");
        Double user_double = Main.scan.nextDouble();
        Main.scan.nextLine();
        System.out.println("Enter a String below:");
        String user_string = Main.scan.nextLine();

        System.out.println("String: " + user_string);
        System.out.println("Double: " + user_double);
        System.out.println("Int: " + user_integer);
    }
}