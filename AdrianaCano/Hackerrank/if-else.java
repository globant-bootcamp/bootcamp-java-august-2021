//java if-else
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num%2 != 0 || (num <=20 && num>=6)){
            System.out.println("Weird");
        }else{
            if(num>1 && num<6 || num>20){
                System.out.println("Not Weird");
            }
        }
    }
}