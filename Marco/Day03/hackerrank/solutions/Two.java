package hackerrank.solutions;

public class Two{
    public static void resolve(){

        Adder sum = new Adder();

        System.out.println("My superclass is: " + sum.getClass().getSuperclass().getName());

        System.out.print(sum.add(10,32) + " " + sum.add(10,3) + " " + sum.add(10,10) + "\n");

    }
}