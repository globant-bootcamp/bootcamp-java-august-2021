package application.solution.stdin2;

import application.solution.Solution;

public class Stdin2Solution extends Solution {

  private static final String INITIAL_INSTRUCTIONS_IN= "Prompted values \n1. Integer \n2. Double \n3. String";
  private static final String INITIAL_INSTRUCTION_OUT = "The output values would be \n1. String \n2. Double \n3. Integer \nIn that order";
  private static final String VALUE_1_LABEL = "Value 1: ";
  private static final String VALUE_2_LABEL = "Value 2: ";
  private static final String VALUE_3_LABEL = "Value 3: ";
  private static final String RESPONSE_LABEL = "Output \n%s \n%.2f \n%d";

  @Override
  public void solution() {
    String promptedValue3;
    int promptedValue1;
    double promptedValue2;
    System.out.println(Stdin2Solution.INITIAL_INSTRUCTIONS_IN);
    System.out.println(Stdin2Solution.INITIAL_INSTRUCTION_OUT);
    System.out.print(Stdin2Solution.VALUE_1_LABEL);
    promptedValue1 = Integer.parseInt(Solution.scanner.nextLine());
    System.out.print(Stdin2Solution.VALUE_2_LABEL);
    promptedValue2 = Double.parseDouble(Solution.scanner.nextLine());
    System.out.print(Stdin2Solution.VALUE_3_LABEL);
    promptedValue3 = Solution.scanner.nextLine();
    System.out.println(String.format(Stdin2Solution.RESPONSE_LABEL, promptedValue3, promptedValue2, promptedValue1));
  }
}
