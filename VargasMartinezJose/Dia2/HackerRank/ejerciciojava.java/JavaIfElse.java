public class JavaIfElse{



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int number = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        
        
        if(number % 2 ==1 | (number % 2 ==0 & number >= 6 && number <= 20) ){
            System.out.println("Weird");
        }
        else if (number % 2 ==0 && (number > 20 && number <=100) |
                                    number % 2 ==0 &(number >= 2 && number <= 5)){
            System.out.println("Not Weird");
        }
        else {
            System.out.println("Number greater 100");
        }
         
        scanner.close();
    }
}
