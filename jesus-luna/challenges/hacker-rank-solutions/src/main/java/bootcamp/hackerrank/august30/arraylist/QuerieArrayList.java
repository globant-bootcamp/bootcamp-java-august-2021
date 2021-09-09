package bootcamp.hackerrank.august30.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bootcamp.hackerrank.Solution;

public class QuerieArrayList extends Solution {

	private static final String LINE_OUTPUT_FORMAT = "LINE %d => %s";
	private static final String LINE_INDICATOR = "LINE %d: ";
	private static final String LINE_TITLE = "Printing lines";
	private static final String LINE_OUTLINE = "LINE FORMAT => The first element is the expected number of elements, so then spaced-separated numbers for the line";
	private static final String LINE_ERROR = "Expected number of elements: %d";
	private static final String NUMBER_LINES_OUTLINE = "Give number of lines: ";
	private static final String NUMBER_LINES_ERROR = "Number of lines must be between 1 - 20000";
	private static final String INDEX_ERROR = "ERROR! Line: %d, value: %d, didnt match with the provided above";
	private static final String VALUE_FOUND = "Value found: %d";
	private static final String NUMBER_QUERY_OUTLINE = "Give number of queries: ";
	private static final String QUERY_OUTLINE = "QUERY FORMAT => The first element is the line, the second one is the position element to look for. Index begin at 1.";
	private static final String QUERY_INDICATOR = "Query %d: ";
	private static final String QUERY_SIZE_ERROR = "The number of queries must be between 1 - 1000";
	private static final String QUERY_INVALID_ERROR = "The query didnt match with the format";
	private static final String SPLIT_SEPARATOR_SPACE = " ";
	private static final String CURL_CHARACTER_OPEN = "{";
	private static final String CURL_CHARACTER_CLOSE = "}";

	private List<List<Integer>> listOfLines = new ArrayList<>();
	private String outline;
	private String errorMsg;

	@Override
	public void solve() {
		storeLines();
		printLines();
		performQueries();
	}

	private void storeLines() {
		outline = QuerieArrayList.NUMBER_LINES_OUTLINE;
		errorMsg = QuerieArrayList.NUMBER_LINES_ERROR;
		int numberOfLines = getValidNumber(outline, errorMsg, 20000);
		outline = QuerieArrayList.LINE_OUTLINE;
		System.out.println(outline);
		for (int index = 0; index < numberOfLines; index++) {
			storeLine(index + 1);
		}
	}

	private int getValidNumber(String outlineToDisplay, String errorToDisplay, int maxSize) {
		int validNumber = Solution.readIntegerInput(outlineToDisplay);
		if (validNumber < 1 || validNumber > maxSize) {
			System.out.println(errorToDisplay);
			validNumber = getValidNumber(outlineToDisplay, errorToDisplay, maxSize);
		}
		return validNumber;
	}

	private void storeLine(int numberLine) {
		List<Integer> validNumericList;
		outline = String.format(QuerieArrayList.LINE_INDICATOR, numberLine);
		System.out.print(outline);
		String lineOfElements = Solution.scanner.nextLine();
		String[] splittedElements = lineOfElements.split(QuerieArrayList.SPLIT_SEPARATOR_SPACE);
		List<String> stringElements = Arrays.asList(splittedElements);
		validNumericList = stringElements.stream().filter(element -> element.chars().allMatch(Character::isDigit))
				.map(Integer::parseInt).collect(Collectors.toList());
		int numberOfElements = validNumericList.get(0);
		validNumericList.remove(0);
		if (validNumericList.size() != numberOfElements) {
			errorMsg = String.format(QuerieArrayList.LINE_ERROR, numberOfElements);
			System.out.println(errorMsg);
			storeLine(numberLine);
		} else {
			listOfLines.add(validNumericList);
		}
	}

	private void printLines() {
		outline = QuerieArrayList.LINE_TITLE;
		System.out.println(outline);
		for (int index = 0; index < listOfLines.size(); index++) {
			String lineContent = listOfLines.get(index).stream().map(String::valueOf)
					.collect(Collectors.joining(SPLIT_SEPARATOR_SPACE, CURL_CHARACTER_OPEN, CURL_CHARACTER_CLOSE));
			outline = String.format(QuerieArrayList.LINE_OUTPUT_FORMAT, index + 1, lineContent);
			System.out.println(outline);
		}
	}

	private void performQueries() {

		outline = QuerieArrayList.NUMBER_QUERY_OUTLINE;
		errorMsg = QuerieArrayList.QUERY_SIZE_ERROR;
		int numberOfQueries = getValidNumber(outline, errorMsg, 1000);
		outline = QuerieArrayList.QUERY_OUTLINE;
		System.out.println(outline);
		for (int index = 0; index < numberOfQueries; index++) {
			outline = String.format(QuerieArrayList.QUERY_INDICATOR, index + 1);
			System.out.print(outline);
			String[] splittedInput = Solution.scanner.nextLine().split(QuerieArrayList.SPLIT_SEPARATOR_SPACE);
			if (splittedInput.length < 2) {
				outline = QuerieArrayList.QUERY_INVALID_ERROR;
				System.out.println(outline);
			} else {
				int realLineIndex = Integer.valueOf(splittedInput[0]) - 1;
				int realElementIndex = Integer.valueOf(splittedInput[1]) - 1;
				printQueriResult(realLineIndex, realElementIndex);
			}
		}
	}

	private void printQueriResult(int lineTarget, int indexTaget) {
		int lineTargetOutput = lineTarget + 1;
		int iindexTagetOutput = indexTaget + 1;
		try {
			List<Integer> line = listOfLines.get(lineTarget);
			Integer number = line.get(indexTaget);
			outline = String.format(QuerieArrayList.VALUE_FOUND, number);
			System.out.println(outline);
		} catch (IndexOutOfBoundsException e) {
			errorMsg = String.format(QuerieArrayList.INDEX_ERROR, lineTargetOutput, iindexTagetOutput);
			System.out.println(errorMsg);
		}
	}

}
