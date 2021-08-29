
public class JavaOutputFormatting{

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String strings = sc.next();
                int integers = sc.nextInt();
                System.out.printf("%-15s%03d%n",strings, integers);
            }
            System.out.println("================================");

    }

}

