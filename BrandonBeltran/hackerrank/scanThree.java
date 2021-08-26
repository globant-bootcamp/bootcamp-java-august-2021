package bootcamp;

import java.util.Scanner;

public class scanThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*
        * I don't feel comfortable mixing nextInt, nextDouble,
        * nextLine. nextInt doesn't read the next new-line character,
        * so the nextLine would act up. Here I just read nextLine and
        * parse it into the desired datatype. One integer, one double
        * and one string.
        */

        int i = Integer.parseInt(scan.nextLine());
        double d = Double.parseDouble(scan.nextLine());
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}