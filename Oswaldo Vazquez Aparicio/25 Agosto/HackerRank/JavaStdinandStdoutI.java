import java.util.Scanner;

public class JavaStdinandStdoutI {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfIntegersToRead = 3;
        for(int i = 0; i < numOfIntegersToRead; i++){
            System.out.println(scan.nextInt());
        }
        scan.close();
    }
    
}