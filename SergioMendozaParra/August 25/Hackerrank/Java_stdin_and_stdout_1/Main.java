package myPackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i;
        int[] numbers =  new int[3];
        for(i = 0; i < 3; i++)
            numbers[i] = scan.nextInt();
        for(i = 0; i < 3; i++)
            System.out.println(numbers[i]);
    }
}
