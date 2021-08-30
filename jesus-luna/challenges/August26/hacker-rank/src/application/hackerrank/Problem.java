package application.hackerrank;

import java.util.Scanner;

public abstract class Problem {

  protected static final Scanner scanner = new Scanner(System.in);

  public static void closeScanner(){
    Problem.scanner.close();
  }
  
  public abstract void solve();
  
}
