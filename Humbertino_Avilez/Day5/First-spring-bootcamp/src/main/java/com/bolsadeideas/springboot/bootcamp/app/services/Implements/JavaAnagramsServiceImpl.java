package com.bolsadeideas.springboot.bootcamp.app.services.Implements;

import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.ANSWER_ANAGRAM_NO;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.ANSWER_ANAGRAM_YES;
import com.bolsadeideas.springboot.bootcamp.app.services.JavaAnagramsService;

@Service
public class JavaAnagramsServiceImpl implements JavaAnagramsService {
	private static final Logger javaLog = Logger.getLogger(JavaAnagramsServiceImpl.class);
	Map<Character, Integer> wordMap;
	Map<Character, Integer> anagramMap;

	@Override
	public String validateAnagram(String word, String anagram) {
		wordMap = new Hashtable<>();
		anagramMap = new Hashtable<>();
		anagram = anagram.toLowerCase();
		if (word.length() == anagram.length()) {
			for (int i = 0; i < word.length(); i++) {
				if (wordMap.containsKey(word.charAt(i))) {
					wordMap.put(word.charAt(i), wordMap.get(word.charAt(i)) + 1);
				} else {
					wordMap.put(word.charAt(i), 1);
				}
				if (anagramMap.containsKey(anagram.charAt(i))) {
					anagramMap.put(anagram.charAt(i), anagramMap.get(anagram.charAt(i)) + 1);
				} else {
					anagramMap.put(anagram.charAt(i), 1);
				}
			}
			if (wordMap.equals(anagramMap)) {
				javaLog.debug(ANSWER_ANAGRAM_YES);
				return ANSWER_ANAGRAM_YES;
			} else {
				javaLog.debug(ANSWER_ANAGRAM_NO);
				return ANSWER_ANAGRAM_NO;
			}
		} else {
			javaLog.debug(ANSWER_ANAGRAM_NO);
			return ANSWER_ANAGRAM_NO;
		}
	}
}
