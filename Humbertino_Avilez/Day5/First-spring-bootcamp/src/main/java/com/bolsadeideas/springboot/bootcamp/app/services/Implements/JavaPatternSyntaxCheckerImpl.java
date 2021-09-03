/**
 * 
 */
package com.bolsadeideas.springboot.bootcamp.app.services.Implements;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constans.ANSWER_VALID;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constans.ANSWER_INVALID;

import com.bolsadeideas.springboot.bootcamp.app.services.JavaPatternSyntaxChecker;

@Service
public class JavaPatternSyntaxCheckerImpl implements JavaPatternSyntaxChecker {
	private static final Logger javaLog = Logger.getLogger(JavaPatternSyntaxCheckerImpl.class);

	@Override
	public String validatePatternRedex(String patternToValidate) {
		try {
			Pattern.compile(patternToValidate);
			javaLog.debug(ANSWER_VALID);
			return ANSWER_VALID;
		} catch (Exception exception) {
			javaLog.debug(ANSWER_INVALID);
			return ANSWER_INVALID;
		}
	}
}
