package aplicacion.solution.weird;

import aplicacion.solution.Solution;

public class WeirdSolution extends Solution {

    @Override
    public void solucion() {
        int n = 0;
        System.out.println("Ask a number, if its odd or its within inclusie range 6 -20, is weird, otherwise is not weird");
        n = Solution.scanner.nextInt();
        Solution.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        String status = null;
        if(n % 2 == 0){
            status = ((n >= 6) && (n <= 20)) ? "Weird" : "Not Weird";
        }else{
            status = "Weird";
        }
        System.out.println("The weirdness of "+n+" is "+status);
    }
    
}
