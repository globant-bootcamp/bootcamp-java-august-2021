package com.bolsadeideas.springboot.bootcamp.app.services.Implements;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constans.ANSWER_YES;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constans.ANSWER_NO;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constans.SYMBOL_SPACE;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constans.SYMBOL_NOSPACE;
import com.bolsadeideas.springboot.bootcamp.app.services.JavaStringReverseService;

@Service
public class JavaStringReverseImpl implements JavaStringReverseService {
	private static final Logger javaLog = Logger.getLogger(JavaStringReverseImpl.class);

	@Override
	public String palindromeWord(String word) {
		word = word.toLowerCase().replace(SYMBOL_SPACE, SYMBOL_NOSPACE);
		String reverseWord = SYMBOL_NOSPACE;
		for (int i = word.length() - 1; i >= 0; i--) {
			reverseWord += word.charAt(i);
		}
		if (word.equals(reverseWord)) {
			javaLog.debug(ANSWER_YES);
			return ANSWER_YES;
		} else {
			javaLog.debug(ANSWER_NO);
			return ANSWER_NO;
		}
	}
}
