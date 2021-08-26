package challenge.solutions;

import challenge.Main;

public class Solution1 {
    int first_number, second_number, third_number;

    public void firstSolution() {

        System.out.println("Enter 3 Integers to be echoed:");
        first_number = Main.scan.nextInt();
        second_number = Main.scan.nextInt();
        third_number = Main.scan.nextInt();
        System.out.println("Echoing...");
        System.out.println(first_number);
        System.out.println(second_number);
        System.out.println(third_number);
    }
}