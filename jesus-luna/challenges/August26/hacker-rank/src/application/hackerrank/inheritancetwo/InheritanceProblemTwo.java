package application.hackerrank.inheritancetwo;

import application.hackerrank.Problem;

public class InheritanceProblemTwo extends Problem {

  private static final String SUPERCLASS_MESSAGE = "My superclass is: %s";
  private static final String ADD_OPERATION_RESULT_LABEL = "Add %d + %d gives %s";

  @Override
  public void solve() {
    Adder adder = new Adder();
    int number1Addition1 = 10;
    int number2Addition1 = 5;
    int number1Addition2 = 20;
    int number2Addition2 = 4;

    System.out.println(
      String.format(InheritanceProblemTwo.SUPERCLASS_MESSAGE, adder.getClass().getSuperclass().getName())
    );
    System.out.println(
      String.format(
        InheritanceProblemTwo.ADD_OPERATION_RESULT_LABEL,
        number1Addition1,
        number2Addition1,
        adder.add(number1Addition1, number2Addition1))
    );
    System.out.println(
      String.format(
        InheritanceProblemTwo.ADD_OPERATION_RESULT_LABEL,
        number1Addition2,
        number2Addition2,
        adder.add(number1Addition2, number2Addition2))
    );
  }
  
}
