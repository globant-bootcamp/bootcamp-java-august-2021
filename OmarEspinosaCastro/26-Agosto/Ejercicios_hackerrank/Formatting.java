package org.example;
public class Formatting {
    
    public static void main(String[] args) {
        String separator = "================================";
        String formato = "%-15s%03d%n";
        Scanner sc = new Scanner(System.in);
        String[] stringIn = new String[3];
        int[] numbers = new int[3];
        for (int indice = 0; indice < 3; indice++) {
            stringIn[indice] = sc.next();
            numbers[indice] = sc.nextInt();
        }
        System.out.println(separator);
        for (int indice = 0; indice < 3; indice++) {
            System.out.printf(formato, stringIn[indice], numbers[indice]);
        }
        System.out.println(separator);
    }
}
