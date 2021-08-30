public class JavaInheritance2 {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int integer_value = scan.nextInt();
        double double_value = scan.nextDouble();
        scan.nextLine();
        String string_value = scan.nextLine();

        System.out.println("String: " + string_value);
        System.out.println("Double: " + double_value);
        System.out.println("Int: " + integer_value);

    }
}
