import java.util.Scanner;

public static boolean flag = true; 
public static int firstParameter ;
public static int secondPArameter ;
public static String area;

public static final String ERROR_MESSAGE = "java.lang.Exception: Breadth and height must be positive";

public class StaticInitializerBlock {


    static {

        Scanner scan = new Scanner(System.in);        
        firstParameter = scan.nextInt();        
        secondPArameter = scan.nextInt();        
        scan.close();
            
        if(firstParameter <= 0 || secondPArameter <= 0){
            System.out.println(ERROR_MESSAGE);
            flag = false;
        }else{
            flag = true;    
        }
        
    }

    public static void main(String[] args){

        if(flag){
            int area = firstParameter * secondPArameter;
            System.out.print(area);
        }
            
    }

}
