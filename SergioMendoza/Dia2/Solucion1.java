import java.util.*;

public class Solucion1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i;
        int[] leer_numeros =  new int[3];
        for(i = 0; i < 3; i++)
            leer_numeros[i] = scan.nextInt();
        for(i = 0; i < 3; i++)
            System.out.println(leer_numeros[i]);
    }
}
