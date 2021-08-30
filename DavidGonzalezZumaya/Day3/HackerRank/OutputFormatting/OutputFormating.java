import java.util.Scanner;

public class OutputFormating {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String OUTPUT_FORMATTING = "%-15s%03d%n";
        final String DECORATOR_FORMATTING = "================================";
        final int MAX_LENGTH = 3;

        System.out.println(DECORATOR_FORMATTING);

        for (int index = 0; index < MAX_LENGTH; index++) {
            String text = scanner.next();
            int number = scanner.nextInt();
            System.out.printf(OUTPUT_FORMATTING, text, number);
        }

        scanner.close();

        System.out.println(DECORATOR_FORMATTING);

    }

}
