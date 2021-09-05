package bootcamp.hackerrank.august30.map;

import java.util.HashMap;
import java.util.Map;

import bootcamp.hackerrank.Solution;

public class PhoneBook extends Solution {
	
	private static final String NUMBER_ENTRIES_OUTLINE = "Give the number of entries to be introduced: ";
	private static final String NUMBER_ENTRIES_ERROR_MSG = "Number of entries must be between 1 - 1000";
	private static final String NAME_INPUT_OUTLINE = "Give the name of the entry %d: ";
	private static final String PHONE_INPUT_OUTLINE = "Give the phone of the entry %d: ";
	private static final String PHONE_INPUT_ERROR_MSG = "Phone number has exactly 8 digits without any leading zeros";
	private static final String NUMBER_QUERIES_OUTLINE = "Give the number of queries to be introduced: ";
	private static final String NUMBER_QUERIES_ERROR_MSG = "Number of queries must be between 1 - 1000";
	private static final String NAME_QUERY_OUTLINE = "Give name %d to be query: ";
	private static final String ENTRY_NOT_FOUND = "%s not found";
	
	
	

	@Override
	public void solve() {
		int numberOfEntries = getValidNumber(PhoneBook.NUMBER_ENTRIES_OUTLINE,PhoneBook.NUMBER_ENTRIES_ERROR_MSG);
		int phone;
		String name;
		String result;
		String queriedName;
		Map<String, Integer> phoneBook = new HashMap<>();
		for (int index = 0; index < numberOfEntries; index++) {
			name = getValidName(String.format(PhoneBook.NAME_INPUT_OUTLINE, index));
			phone = getValidPhoneNumber(index);
			phoneBook.put(name, phone);
		}
		int numberOfQueries = getValidNumber(PhoneBook.NUMBER_QUERIES_OUTLINE, PhoneBook.NUMBER_QUERIES_ERROR_MSG);
		for (int index = 0; index < numberOfQueries; index++) {
			queriedName = getValidName(String.format(PhoneBook.NAME_QUERY_OUTLINE, index));
			result = (phoneBook.containsKey(queriedName)) ? phoneBook.get(queriedName).toString() : String.format(PhoneBook.ENTRY_NOT_FOUND, queriedName);
			System.out.println(result);
		}
		
	}
	
	private int getValidNumber(String outline, String errorMsg) {
		int numberInputrequired = Solution.readIntegerInput(outline);
		if(numberInputrequired < 1 || numberInputrequired > 1000) {
			System.out.println(errorMsg);
			numberInputrequired = getValidNumber(outline,errorMsg);
		}
		return numberInputrequired;
	}
	
	private String getValidName(String outline) {
		System.out.print(outline);
		return  Solution.scanner.nextLine().toLowerCase();
	}
	
	private int getValidPhoneNumber(int index) {
		int phoneNumber = Solution.readIntegerInput(String.format(PhoneBook.PHONE_INPUT_OUTLINE, index));
		if(getnumberOfDigits(phoneNumber) != 8) {
			System.out.println(PhoneBook.PHONE_INPUT_ERROR_MSG);			
			phoneNumber = getValidPhoneNumber(index);
		}
		return phoneNumber;
	}
	
	private int getnumberOfDigits(int input) {
		int digits = 0;
		while (input != 0) {
			input = input / 10;
			digits++;
		}
		return digits;
	}

}
