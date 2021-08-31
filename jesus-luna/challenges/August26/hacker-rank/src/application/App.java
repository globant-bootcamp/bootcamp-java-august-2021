package application;

import application.hackerrank.Problem;
import application.hackerrank.formatting.FormattingProblem;
import application.hackerrank.inheritanceone.InheritanceProblemOne;
import application.hackerrank.inheritancetwo.InheritanceProblemTwo;

public class App {

  private static final String MAIN_TITLE = "HackerRank challenges";
  private static final String CHALLENGE_1_TITLE = "\nJava Inheritance I";
  private static final String CHALLENGE_2_TITLE = "\nJava Inheritance II";
  private static final String CHALLENGE_3_TITLE = "\nJava Output Formatting";

  public static void main(String[] args) throws Exception {
    Problem problem;
    System.out.println(App.MAIN_TITLE);
    
    System.out.println(App.CHALLENGE_1_TITLE);
    problem = new InheritanceProblemOne();
    problem.solve();

    System.out.println(App.CHALLENGE_2_TITLE);
    problem = new InheritanceProblemTwo();
    problem.solve();

    System.out.println(App.CHALLENGE_3_TITLE);
    problem = new FormattingProblem();
    problem.solve();
  }
}
