package com.hackerrank.serviceImp;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.springframework.stereotype.Service;
import com.hackerrank.exception.PatternException;
import com.hackerrank.service.ExerciseService;
import com.hackerrank.utils.Constants;

@Service
public class ExerciseServiceImp implements ExerciseService {

	@Override
	public String palindrome(String palindromeInput) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(palindromeInput);
		String stringReversed = stringBuilder.reverse().toString();

		String isPalindrome = (stringReversed.equalsIgnoreCase(palindromeInput)) ? Constants.YES : Constants.NO;
		return isPalindrome;
	}

	@Override
	public String patternSyntaxChecker(String patternInput) {
		try {
			Pattern.compile(patternInput);
			return Constants.VALID;
		} catch (PatternSyntaxException e) {
			throw new PatternException(Constants.INVALID);
		}
	}

	@Override
	public String anagram(String firstAnagramInput, String secondTextInput) {

		boolean isAnagram = isAnagram(firstAnagramInput, secondTextInput);
		String result = (isAnagram) ? Constants.ANAGRAMS : Constants.NOT_ANAGRAMS;
		return result;
	}

	public static boolean isAnagram(String firstString, String secondString) {
		char[] firstStringConvertedToChar = firstString.toLowerCase().toCharArray();
		char[] secondStringConvertedToChar = secondString.toLowerCase().toCharArray();

		if (firstString.length() != secondString.length()) {
			return false;
		} else {
			Arrays.sort(firstStringConvertedToChar);
			Arrays.sort(secondStringConvertedToChar);
			return Arrays.equals(firstStringConvertedToChar, secondStringConvertedToChar);
		}
	}

}
