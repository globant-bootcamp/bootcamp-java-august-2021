package MyFirstGradleProject;

import org.apache.log4j.Logger;

public class JavaIntToString {
	private static final Logger LOG = Logger.getLogger(JavaStaticInitializer.class);
	final static String ENTER_NUMBER = "Enter number: ";

	private static void main() {
		LOG.debug(ENTER_NUMBER);
		int number = Validations.validNumber();
	}

}
