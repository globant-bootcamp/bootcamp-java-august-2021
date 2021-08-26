import java.util.Scanner;

public class JavaStdinAndStdoutI {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] inputs = new int[3];

    inputs[0] = scanner.nextInt();
    inputs[1] = scanner.nextInt();
    inputs[2] = scanner.nextInt();

    for(int element : inputs)
      System.out.println(element);
  }

}
