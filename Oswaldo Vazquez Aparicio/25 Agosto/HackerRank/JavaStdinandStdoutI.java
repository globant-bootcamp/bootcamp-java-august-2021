import java.util.Scanner;

public class JavaStdinandStdoutl {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int integersNum = 3;
        for(int i = 0; i < integersNum; i++){
            System.out.println(scan.nextInt());
        }
        scan.close();
    }
    
}