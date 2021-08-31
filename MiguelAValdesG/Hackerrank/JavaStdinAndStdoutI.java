import java.util.Scanner;

public class JavaStdinAndStdoutI {

  public static void main(String[] args) {
    Scanner readLineTerminal = new Scanner(System.in);
    final int INPUT_ARRAY_SIZE = 3;
    int[] inputs = new int[INPUT_ARRAY_SIZE];

    inputs[0] = readLineTerminal.nextInt();
    inputs[1] = readLineTerminal.nextInt();
    inputs[2] = readLineTerminal.nextInt();

    for(int element : inputs)
      System.out.println(element);
  }

}
