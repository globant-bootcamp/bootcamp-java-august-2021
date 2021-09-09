package bootcamp;

import bootcamp.hackerrank.Solution;
import bootcamp.hackerrank.august30.List.QuerieList;
import bootcamp.hackerrank.august30.arraylist.QuerieArrayList;
import bootcamp.hackerrank.august30.hashset.UniquePairs;
import bootcamp.hackerrank.august30.map.PhoneBook;
import bootcamp.hackerrank.august30.ramsonnote.RansomNote;
import bootcamp.hackerrank.august30.sort.ReArrange;
import bootcamp.hackerrank.august31.converter.IntToString;
import bootcamp.hackerrank.august31.currency.CurrencyFormatter;
import bootcamp.hackerrank.august31.staticinitializer.StatickInitializerBlock;

public class App {
	
	public static void main(String[] args) {
		new App().testHackerRank();
	}

	public void testHackerRank() {
		Solution solution = null;
		hackerRankAugust31(solution);
		Solution.closeScanner();
	}

	private void hackerRankAugust30(Solution solution) {
		solution = new RansomNote();
		solution.solve();

		solution = new ReArrange();
		solution.solve();

		solution = new UniquePairs();
		solution.solve();

		solution = new PhoneBook();
		solution.solve();

		solution = new QuerieList();
		solution.solve();

		solution = new QuerieArrayList();
		solution.solve();
	}
	
	
	private void hackerRankAugust31(Solution solution) {
		StatickInitializerBlock.solve();
		
		solution = new CurrencyFormatter();
		solution.solve();
		
		solution = new IntToString();
		solution.solve();		
	}
}
