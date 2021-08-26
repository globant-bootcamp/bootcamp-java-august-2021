public class Solution3 {

    public void thirdSolution() {

        System.out.println("Enter an Integer below");
        int i = Main.scan.nextInt();
        System.out.println("Enter a Double below");
        Double d = Main.scan.nextDouble();
        Main.scan.nextLine();
        System.out.println("Enter a String below:");
        String s = Main.scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}