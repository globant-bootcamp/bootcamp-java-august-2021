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
	Map<Character, Integer> wordMap = new Hashtable<>();
	Map<Character, Integer> anagramMap = new Hashtable<>();

	@Override
	public String validateAnagram(String word, String anagram) {
		word = word.toLowerCase();
		anagram = anagram.toLowerCase();
		if (word.length() == anagram.length()) {
			for (int i = 0; i < word.length(); i++) {
				wordMap = countingElements(wordMap, word.charAt(i));
				anagramMap = countingElements(anagramMap, anagram.charAt(i));
			}
			if (wordMap.equals(anagramMap)) {
				javaLog.debug(ANSWER_ANAGRAM_YES);
				cleanMaps();
				return ANSWER_ANAGRAM_YES;
			} else {
				javaLog.debug(ANSWER_ANAGRAM_NO);
				cleanMaps();
				return ANSWER_ANAGRAM_NO;
			}
		} else {
			javaLog.debug(ANSWER_ANAGRAM_NO);
			return ANSWER_ANAGRAM_NO;
		}
	}

	private Map<Character,Integer> countingElements(Map<Character, Integer> searchElementMap, Character element){
		if(searchElementMap.containsKey(element)) {
			searchElementMap.put(element, searchElementMap.get(element) + 1);
		}else {
			searchElementMap.put(element, 1);
		}
		return searchElementMap;
	}

	private void cleanMaps() {
		wordMap.clear();
		anagramMap.clear();
	}
}
