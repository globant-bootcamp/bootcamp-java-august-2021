public class JavaOutputFormatting {

    public static final Scanner scan = new Scanner(System.in);
    public static final String LINES = "================================";
    public static final String FORMAT1 = "%-15s%03d%n";

    public static void main(String[] args) {

        System.out.println(LINES);

        for (int index = 0; index < 3; index++) {
            String strings_value = scan.next();
            int integers_value = scan.nextInt();
            System.out.printf(FORMAT1, strings_value, integers_value);
        }
        System.out.println(LINES);

    }

}
