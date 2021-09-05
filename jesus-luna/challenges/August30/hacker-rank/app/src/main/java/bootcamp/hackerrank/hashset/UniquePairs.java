package bootcamp.hackerrank.hashset;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

import bootcamp.hackerrank.Solution;

public class UniquePairs extends Solution{
	
	private String [] pairLeft;
	private String [] pairRight;
	private int numberOfPairs;
	private enum INPUT{KEY,VALUE};
	
	private static final String INPUT_OUTLINE = "Give a %s for the pair %d: ";
	private static final String GIVE_NUMBER_PAIRS = "Give number of pairs to be stored: ";
	private static final String INPUT_NUMBER_INCORRECT = "Input must be a number";
	private static final String NUMBER_PAIRS_INCORRECT = "The number of pairs must be between 1 - 10000";
	private static final String INPUT_TEXT_INCORRECT = "The value must be at most 5 letters";
	private static final String SET_FORMAT = "%s %s";

	@Override
	public void solve() {
		Set<String> stringPairs = new HashSet<>();
		fillArrays();
		for (int index = 0; index < numberOfPairs; index++) {
			stringPairs.add(String.format(UniquePairs.SET_FORMAT, pairLeft[index],pairRight[index]));
			System.out.println(stringPairs.size());
		}
	}

	private void fillArrays() {
		numberOfPairs = readNumberOfPairsValid();
    pairLeft = new String[numberOfPairs];
    pairRight = new String[numberOfPairs];
    for (int index = 0; index < numberOfPairs; index++) {
        pairLeft[index] = readValidStringValue(UniquePairs.INPUT.KEY.name(),index);
        pairRight[index] = readValidStringValue(UniquePairs.INPUT.VALUE.name(),index);
    }
    
	}
	
	private int readNumberOfPairsValid() {
		int numberPairs = readIntegerInput(UniquePairs.GIVE_NUMBER_PAIRS);
		if(numberPairs < 1 || numberPairs > 1000) {
			System.out.println(UniquePairs.NUMBER_PAIRS_INCORRECT);
			numberPairs = readNumberOfPairsValid();
		}
		return numberPairs;
		
	}
	
	private String readValidStringValue(String inputExpected,int numberOfPair) {
		String value;
		System.out.print(String.format(UniquePairs.INPUT_OUTLINE, inputExpected,numberOfPair));
		value = Solution.scanner.nextLine().toLowerCase();
		if(value.length() > 5) {
			System.out.println(UniquePairs.INPUT_TEXT_INCORRECT);
			Solution.scanner.nextLine();
			value = readValidStringValue(inputExpected,numberOfPair);
		}
		return value;
	}
	
	private int readIntegerInput(String instruction) {
		int intInput;
		try {
			System.out.print(instruction);
			intInput = Solution.scanner.nextInt();
			Solution.scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println(UniquePairs.INPUT_NUMBER_INCORRECT);
			Solution.scanner.nextLine();
			intInput = readIntegerInput(instruction);
		}
		return intInput;
	}

}
