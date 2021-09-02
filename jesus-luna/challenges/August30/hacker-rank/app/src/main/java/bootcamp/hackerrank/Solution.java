package bootcamp.hackerrank;

import java.util.Scanner;

public abstract class Solution {
	protected static final Scanner scanner = new Scanner(System.in);
  
  public abstract void solve();

  public static void closeScanner() {
    Solution.scanner.close();
  }
}
