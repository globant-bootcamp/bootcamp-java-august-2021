import java.util.Scanner;

public class Solucion3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);    
        int num_entero = scan.nextInt();
        double num_con_decimales = scan.nextDouble();
        String cadena = scan.nextLine(); 
        cadena = scan.nextLine();
        
        System.out.println("String: " + cadena);
        System.out.println("Double: " + num_con_decimales);
        System.out.println("Int: " + num_entero);
    }
}
