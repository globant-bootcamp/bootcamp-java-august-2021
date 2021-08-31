package org.example;
public class Solution {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int indice=0;indice<3;indice++){
                String stringIn=sc.next();
                int number=sc.nextInt();
                 System.out.printf("%-15s%03d%n",stringIn,number);
            }
            System.out.println("================================");
    }
}
