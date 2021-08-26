import java.util.Scanner;

public class stdinAndStdoutII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String stringInp = "";
        int intInp = 0;
        Double doubleInp = 0.0; 
        int counter = 0;

        do {
            stringInp = scan.nextLine();
            if(counter ==0)
                intInp = Integer.parseInt(stringInp);
            if(counter == 1)
                doubleInp = Double.parseDouble(stringInp);
            ++counter;
        } while(counter < 3);

        scan.close();
        System.out.println("String: " + stringInp);
        System.out.println("Double: " + doubleInp);
        System.out.println("Int: " + intInp);
    }
}
