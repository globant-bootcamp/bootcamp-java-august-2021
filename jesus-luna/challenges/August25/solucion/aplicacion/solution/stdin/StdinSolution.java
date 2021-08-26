package aplicacion.solution.stdin;

import aplicacion.solution.Solution;

public class StdinSolution extends Solution {

    @Override
    public void solucion() {        
        System.out.println("Ask 3 numbers, and print them on console ...");
        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number "+(i+1)+": ");
            numbers[i] = Solution.scanner.nextInt();
        }  
        for (int i : numbers) {
            System.out.println("Number introduced = "+i);          
        }
    }
    
}
