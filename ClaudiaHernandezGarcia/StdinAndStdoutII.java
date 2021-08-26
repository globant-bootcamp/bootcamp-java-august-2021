import java.util.*;

public class StdinAndStdoutII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String s = "";
        int i = 0;
        Double d = 0.0; 
        int counter = 0;

        do {
            s = scan.nextLine();
            //System.out.println("String read: " + s); 
            if(counter ==0)
                i = Integer.parseInt(s);
            if(counter == 1)
                d = Double.parseDouble(s);
            ++counter;
        } while(counter < 3);

        scan.close();
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
