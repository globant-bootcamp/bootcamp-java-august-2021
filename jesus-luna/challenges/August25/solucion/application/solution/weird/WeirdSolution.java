package application.solution.weird;

import application.solution.Solution;

public class WeirdSolution extends Solution {

  private static final String INITIAL_WEIRD_CHALLENGE_INSTRUCTIONS = "Give a number, if its odd or its within inclusie range 6 -20, is weird, otherwise is not weird";
  private static final String SKIP_PATTERN = "(\r\n|[\n\r\u2028\u2029\u0085])?";
  private static final String WEIRD_VALUE = "Weird";
  private static final String NOT_WEIRD_VALUE = "Not Weird";
  private static final String RESPONSE_MESSAGE = "The weirdness of %d is %s";

  @Override
  public void solution() {
    int promptedValue;
    String response;
    System.out.println(WeirdSolution.INITIAL_WEIRD_CHALLENGE_INSTRUCTIONS);
    promptedValue = Solution.scanner.nextInt();
    Solution.scanner.skip(WeirdSolution.SKIP_PATTERN);
    if (promptedValue % 2 == 0) {
      response = ((promptedValue >= 6) && (promptedValue <= 20)) ? WeirdSolution.WEIRD_VALUE : WeirdSolution.NOT_WEIRD_VALUE;
    } else {
      response = WeirdSolution.WEIRD_VALUE;
    }
    System.out.println(String.format(WeirdSolution.RESPONSE_MESSAGE, promptedValue,response));
  }

}
