package bootcamp.hackerrank.august30.List;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import bootcamp.hackerrank.Solution;

public class QuerieList extends Solution {

	private static final String NUMBER_ELEMENTS_OUTLINE = "Give the number of elements to be stored in the list: ";
	private static final String NUMBER_ELEMENTS_ERROR_MSG = "Number of elements must be between 1 - 4000";
	private static final String ELEMENTS_OUTLINE = "Give %d numeric elements separated by a space: ";
	private static final String ELEMENTS_ERROR_MSG = "We are expecting %d numeric elements";
	private static final String NUMBER_QUERIES_OUTLINE = "Give the number of queries to perform in the list: ";
	private static final String NUMBER_QUERIES_ERROR_MSG = "Number of queries must be between 1 - 4000";
	private static final String QUERY_OUTLINE = "Give  %d query to be performed: ";
	private static final String ELEMENT_INDEX_TO_DELETE = "Give the index of element to delete: ";
	private static final String INDEX_TO_DELETE_ERROR_MSG = "Index must be between 1- 4000";
	private static final String ELEMENT_NOT_FOUND = "The element with index %d was not found";
	private static final String AVAILABLE_OPERATIONS = "Available operations: {%s %s}";
	private static final String INSERT_OPERATION = "insert";
	private static final String DELETE_OPERATION = "delete";
	private static final String NOT_SUPPORTED_OPERATION = "Operation not supported";
	private static final String SPLIT_SEPARATOR_SPACE = " ";
	private static final String CURL_CHARACTER_OPEN = "{";
	private static final String CURL_CHARACTER_CLOSE = "}";

	private List<Integer> listOfNumber;
	private String outline;
	private String errorMsg;

	@Override
	public void solve() {
		createList();
		printList();
		performQueries();
	}

	private void createList() {
		outline = QuerieList.NUMBER_ELEMENTS_OUTLINE;
		errorMsg = QuerieList.NUMBER_ELEMENTS_ERROR_MSG;
		int numberOfElements = getValidNumber(outline, errorMsg);
		listOfNumber = getValidNumericList(numberOfElements);
	}

	private void printList() {
		String printingList = listOfNumber.stream().map(String::valueOf)
				.collect(Collectors.joining(SPLIT_SEPARATOR_SPACE, CURL_CHARACTER_OPEN, CURL_CHARACTER_CLOSE));
		System.out.println(printingList);
	}

	private int getValidNumber(String outlineToDisplay, String errorToDisplay) {
		int numberOfElements = Solution.readIntegerInput(outlineToDisplay);
		if (numberOfElements < 1 || numberOfElements > 4000) {
			System.out.println(errorToDisplay);
			numberOfElements = getValidNumber(outlineToDisplay, errorToDisplay);
		}
		return numberOfElements;
	}

	private List<Integer> getValidNumericList(int numberOfElements) {
		List<Integer> validNumericList;
		outline = String.format(QuerieList.ELEMENTS_OUTLINE, numberOfElements);
		System.out.print(outline);
		String lineOfElements = Solution.scanner.nextLine();
		String[] splittedElements = lineOfElements.split(QuerieList.SPLIT_SEPARATOR_SPACE);
		List<String> stringElements = Arrays.asList(splittedElements);

		validNumericList = stringElements.stream().filter(element -> element.chars().allMatch(Character::isDigit))
				.map(Integer::parseInt).collect(Collectors.toList());

		if (validNumericList.size() < numberOfElements) {
			errorMsg = String.format(QuerieList.ELEMENTS_ERROR_MSG, numberOfElements);
			System.out.println(errorMsg);
			validNumericList = getValidNumericList(numberOfElements);
		}
		return validNumericList;
	}

	private void performQueries() {
		String query;
		outline = QuerieList.NUMBER_QUERIES_OUTLINE;
		errorMsg = QuerieList.NUMBER_QUERIES_ERROR_MSG;
		int numberOfQueries = getValidNumber(outline, errorMsg);
		outline = String.format(QuerieList.AVAILABLE_OPERATIONS, QuerieList.INSERT_OPERATION, QuerieList.DELETE_OPERATION);
		System.out.println(outline);
		for (int index = 0; index < numberOfQueries; index++) {
			outline = String.format(QuerieList.QUERY_OUTLINE, index + 1);
			System.out.print(outline);
			query = Solution.scanner.nextLine().toLowerCase();
			switch (query) {
				case QuerieList.INSERT_OPERATION:
					safetyInsertion();
					printList();
					break;
				case QuerieList.DELETE_OPERATION:
					safetyDelete();
					printList();
					break;
				default:
					System.out.println(QuerieList.NOT_SUPPORTED_OPERATION);
					break;
			}
		}
	}

	private void safetyInsertion() {
		List<Integer> operationInsert = getValidNumericList(2);
		int indexToPerform = operationInsert.get(0);
		int valueToOperate = operationInsert.get(1);
		if (indexToPerform >= listOfNumber.size()) {
			listOfNumber.add(valueToOperate);
		} else {
			listOfNumber.add(indexToPerform, valueToOperate);
		}
	}

	private void safetyDelete() {
		int indexToDelete = getValidNumber(QuerieList.ELEMENT_INDEX_TO_DELETE, QuerieList.INDEX_TO_DELETE_ERROR_MSG);
		indexToDelete--;
		try {
			listOfNumber.remove(indexToDelete);
		} catch (IndexOutOfBoundsException e) {
			errorMsg = String.format(QuerieList.ELEMENT_NOT_FOUND, indexToDelete);
			System.out.println(errorMsg);
		}
	}
	
}
