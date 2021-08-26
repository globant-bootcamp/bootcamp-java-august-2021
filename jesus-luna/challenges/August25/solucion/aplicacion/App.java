package aplicacion;

import aplicacion.solution.Solution;
import aplicacion.solution.stdin.StdinSolution;
import aplicacion.solution.stdin2.Stdin2Solution;
import aplicacion.solution.weird.WeirdSolution;

public class App {

    public static void main(String[] args) {

        System.out.println("Problematicas de HackerRank");
        Solution problem = null;
        
        System.out.println("\nJava Stdin and Stdout I");
        problem = new StdinSolution();
        problem.solucion();

        System.out.println("\nJava If-Else");
        problem = new WeirdSolution();
        problem.solucion();

        System.out.println("\nJava Stdin and Stdout II");
        problem = new Stdin2Solution();
        problem.solucion();

        Solution.closeScanner();

        


    }
}
