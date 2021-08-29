package application.hackerrank.formatting;

import application.hackerrank.Problem;

public class FormattingProblem extends Problem {

  private static final String OUTPUT_VALUE = "%-15s%03d\n";
  private static final String LINE_DIVISOR = "================================\n";
  private static final int NUM_ITERATIONS = 3;
  private static final String INSTRUCTIONS_VALUE_1_FORMAT = "String will have a maximum of 10 alphabetic characters: ";
  private static final String INSTRUCTIONS_VALUE_2_FORMAT = "Integer will be in the inclusive range from 0 to 999: ";
  private String valueColumn1;
  private int valueColumn2;

  @Override
  public void solve() {
    StringBuilder outputBuilder = new StringBuilder(FormattingProblem.LINE_DIVISOR);
    
    for (int index = 0; index < FormattingProblem.NUM_ITERATIONS; index++) {
      do {
        System.out.print(FormattingProblem.INSTRUCTIONS_VALUE_1_FORMAT);
        valueColumn1 = Problem.scanner.next();        
      } while (valueColumn1.length() >= 10);
      do {
        System.out.print(FormattingProblem.INSTRUCTIONS_VALUE_2_FORMAT);
        valueColumn2 = Problem.scanner.nextInt();
      } while (valueColumn2 >= 999);
      outputBuilder.append(String.format(FormattingProblem.OUTPUT_VALUE, valueColumn1,valueColumn2));
    }
    outputBuilder.append(FormattingProblem.LINE_DIVISOR);

    System.out.println(outputBuilder.toString());    
  }

}
