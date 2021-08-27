package application.solution.stdin;

import application.solution.Solution;

public class StdinSolution extends Solution {

  private static final String STDIN_CHALLENGE_TITLE = "Ask 3 numbers, and print them on console ...";
  private static final String LABEL_NUMBER_PROMPTED = "Number %d : ";
  private static final String LABEL_NUMBER_OUTPUT = "Number introduced = %d";

  @Override
  public void solution() {
    System.out.println(StdinSolution.STDIN_CHALLENGE_TITLE);
    int[] numbers = new int[3];
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(String.format(StdinSolution.LABEL_NUMBER_PROMPTED,(i + 1)));
      numbers[i] = Solution.scanner.nextInt();
    }
    for (int i : numbers) {
      System.out.println(String.format(StdinSolution.LABEL_NUMBER_OUTPUT, i));
    }
  }
}
