import java.util.Scanner;

public class StdinStdout2 {
	
	    public static void main(String[] args) {
	    	
	    	System.out.println("Introduce");
	    	
	        Scanner scan = new Scanner(System.in);
	        int i = scan.nextInt();
	        double d = scan.nextDouble();
	        String s = "";
	        while(scan.hasNextLine()) {
	        	s += scan.nextLine();
	        }
	        
	        scan.close();

	        System.out.println("String: " + s);
	        System.out.println("Double: " + d);
	        System.out.println("Int: " + i);
	    }
}
