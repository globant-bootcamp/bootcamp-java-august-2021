package com.company;

import java.util.Scanner;

public class StdIntStdOutOne {

    public static final int CYCLE_NUMBER = 3;

    public static void main(String[] args) {
        int cont = 0;
        Scanner scan = new Scanner(System.in);
        while (cont < CYCLE_NUMBER) {
            cont++;
            System.out.println(scan.nextInt());
        }
        scan.close();
    }
}
