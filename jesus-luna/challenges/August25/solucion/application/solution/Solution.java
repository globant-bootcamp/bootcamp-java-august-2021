package application.solution;

import java.util.Scanner;

public abstract class Solution {
  
  protected static final Scanner scanner = new Scanner(System.in);
  
  public abstract void solution();

  public static void closeScanner() {
    Solution.scanner.close();
  }
}
