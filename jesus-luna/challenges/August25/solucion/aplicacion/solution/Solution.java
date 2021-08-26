package aplicacion.solution;

import java.util.Scanner;

public abstract class Solution {
    protected static final Scanner scanner = new Scanner(System.in);

    public abstract void solucion();

    public static void closeScanner(){
        Solution.scanner.close();
    }
}
