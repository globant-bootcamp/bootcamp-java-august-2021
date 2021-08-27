package application;

import application.solution.Solution;
import application.solution.stdin.StdinSolution;
import application.solution.stdin2.Stdin2Solution;
import application.solution.weird.WeirdSolution;

public class App {

  private static final String MAIN_TITLE = "Problematicas de HackerRank";
  private static final String CHALLENGE_1_TITLE = "\nJava Stdin and Stdout I";
  private static final String CHALLENGE_2_TITLE = "\nJava If-Else";
  private static final String CHALLENGE_3_TITLE = "\nJava Stdin and Stdout II";

  public static void main(String[] args) {
    System.out.println(App.MAIN_TITLE);
    Solution problem = null;
    System.out.println(App.CHALLENGE_1_TITLE);
    problem = new StdinSolution();
    problem.solution();
    System.out.println(App.CHALLENGE_2_TITLE);
    problem = new WeirdSolution();
    problem.solution();
    System.out.println(App.CHALLENGE_3_TITLE);
    problem = new Stdin2Solution();
    problem.solution();
    Solution.closeScanner();
  }
}
