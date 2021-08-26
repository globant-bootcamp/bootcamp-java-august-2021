package aplicacion.solution.stdin2;

import aplicacion.solution.Solution;

public class Stdin2Solution extends Solution{

    @Override
    public void solucion() {
        String msg = "Prompted values \n1. Integer \n2. Double \n3. String";
        String msg2 = "The output values would be \n1. String \n2. Double \n3. Integer \nIn that order";
        String response = "Output \n%s \n%.2f \n%d";
        String v3 = "";
        int v1 = 0;
        double v2 = 0.0;
        System.out.println(msg);
        System.out.println(msg2);
        System.out.print("Value 1: ");        
        v1 = Integer.parseInt(Solution.scanner.nextLine());
        System.out.print("Value 2: ");        
        v2 = Double.parseDouble(Solution.scanner.nextLine());
        System.out.print("Value 3: ");        
        v3 = Solution.scanner.nextLine();
        System.out.println(String.format(response, v3,v2,v1));
        
    }
    
}
