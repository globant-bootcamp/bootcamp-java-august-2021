package com.bolsadeideas.springboot.bootcamp.app.services.Implements;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constans.ANSWER_ANAGRAM_NO;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constans.ANSWER_ANAGRAM_YES;

import com.bolsadeideas.springboot.bootcamp.app.services.JavaAnagramsService;

@Service
public class JavaAnagramsServiceImpl implements JavaAnagramsService {
	private static final Logger javaLog = Logger.getLogger(JavaAnagramsServiceImpl.class);

	@Override
	public String isAnagram(String word, String anagram) {
		Hashtable<Character, Integer> wordHashTable = new Hashtable<Character, Integer>();
		Hashtable<Character, Integer> anagramHashTable = new Hashtable<Character, Integer>();
		word = word.toLowerCase();
		anagram = anagram.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			if (wordHashTable.containsKey(word.charAt(i))) {
				wordHashTable.put(word.charAt(i), wordHashTable.get(word.charAt(i)) + 1);
			} else {
				wordHashTable.put(word.charAt(i), 1);
			}
		}
		for (int i = 0; i < anagram.length(); i++) {
			if (anagramHashTable.containsKey(anagram.charAt(i))) {
				anagramHashTable.put(anagram.charAt(i), anagramHashTable.get(anagram.charAt(i)) + 1);
			} else {
				anagramHashTable.put(anagram.charAt(i), 1);
			}
		}
		if (wordHashTable.equals(anagramHashTable)) {
			javaLog.debug(ANSWER_ANAGRAM_YES);
			return ANSWER_ANAGRAM_YES;
		} else {
			javaLog.debug(ANSWER_ANAGRAM_NO);
			return ANSWER_ANAGRAM_NO;
		}
	}
}
