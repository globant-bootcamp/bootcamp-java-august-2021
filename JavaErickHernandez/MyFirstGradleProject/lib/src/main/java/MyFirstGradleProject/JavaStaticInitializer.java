package MyFirstGradleProject;

import java.util.Scanner;

import javax.xml.catalog.Catalog;
import org.apache.log4j.Logger;

public class JavaStaticInitializer {
	private static final Logger LOG = Logger.getLogger(JavaStaticInitializer.class);
	final static String ENTER_BREADTH = "Enter  breadth: ";
	final static String ENTER_HEIGTH = "Enter heigth: ";


	public static void main(String[] args) {
		calculateParallelogram();
	}

	private static void calculateParallelogram() {
		LOG.debug(ENTER_BREADTH);
		int breath = Validations.validNumber();
		LOG.debug(ENTER_HEIGTH);
		int height = Validations.validNumber();
		LOG.debug(breath * height);
	}

}
