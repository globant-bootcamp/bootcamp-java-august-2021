package bootcamp.hackerrank.august31.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bootcamp.hackerrank.Solution;
import bootcamp.hackerrank.august31.currency.CurrencyFormatter;

public class IntToString extends Solution{
	
	private static final Logger log = LogManager.getLogger(IntToString.class.getName());
	private static final String INPUT_NUMBER_OUTLINE = "Give a integer number: ";
	private static final String INPUT_NUMBER_ERROR_MSG= "The given number must be between -100 to 100";
	private static final String GOOD_ANSWER_MSG = "Good job";
	private static final String WRONG_ANSWER_MSG = "Good job";

	@Override
	public void solve() {
		int numberToConvert = Solution.readIntegerInput(IntToString.INPUT_NUMBER_OUTLINE);
		if(numberToConvert < -100 || numberToConvert > 100) {
			log.error(IntToString.INPUT_NUMBER_ERROR_MSG);
		}
		Integer.toString(numberToConvert);
		log.info(IntToString.GOOD_ANSWER_MSG);
	}

}
