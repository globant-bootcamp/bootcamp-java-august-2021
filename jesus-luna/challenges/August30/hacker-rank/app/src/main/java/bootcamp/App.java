/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bootcamp;

import bootcamp.hackerrank.Solution;
import bootcamp.hackerrank.august30.ramsonnote.RansomNote;
import bootcamp.hackerrank.august30.sort.ReArrange;
import bootcamp.hackerrank.hashset.UniquePairs;

public class App {
    public static void main(String[] args) {
        new App().testHackerRank();
    }
    
    public void testHackerRank() {
    	Solution solution = null;
    	hackerRankAugust30(solution);
  		Solution.closeScanner();
    }
    
    private void hackerRankAugust30(Solution solution) {
    	solution = new RansomNote();
  		solution.solve();
    	
    	solution = new ReArrange();
    	solution.solve();
    	
    	solution = new UniquePairs();
    	solution.solve();
    }
}
