import java.util.Scanner;

public class OutputFormating {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String OUTPUT_FORMATTING = "%-15s%03d%n";
        final String DECORATOR_FORMATTING = "================================";

        System.out.println(DECORATOR_FORMATTING);

        for (int i = 0; i < 3; i++) {
            String text = scanner.next();
            int number = scanner.nextInt();
            System.out.printf(OUTPUT_FORMATTING, text, number);
        }

        scanner.close();

        System.out.println(DECORATOR_FORMATTING);

    }

}
