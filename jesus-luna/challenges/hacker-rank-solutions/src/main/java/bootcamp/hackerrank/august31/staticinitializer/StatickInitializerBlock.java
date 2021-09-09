package bootcamp.hackerrank.august31.staticinitializer;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatickInitializerBlock {

	private static final Logger log = LogManager.getLogger(StatickInitializerBlock.class);
	private static final String EXCEPTION_MSG = "java.lang.Exception: Breadth and height must be positive";
	private static final String BREADTH_INPUT_OUTLINE = "Give the breadth of the parralelogram";
	private static final String HEIGHT_INPUT_OUTLINE = "Give the height of the parralelogram";
	private static final String AREA_MSG_OUTPUT = "The area is: {}";
	private static Scanner scanner = new Scanner(System.in);
	private static boolean flag = true;
	private static int inpuBreadthParralelogram;
	private static int inpuHeightParralelogram;

	static {
		log.info(StatickInitializerBlock.BREADTH_INPUT_OUTLINE);
		inpuBreadthParralelogram = scanner.nextInt();
		log.info(StatickInitializerBlock.HEIGHT_INPUT_OUTLINE);
		inpuHeightParralelogram = scanner.nextInt();
		if (inpuBreadthParralelogram <= 0 || inpuHeightParralelogram <= 0) {
			flag = false;
		}
	}

	public static void solve() {
		if (flag) {
			int area = inpuBreadthParralelogram * inpuHeightParralelogram;
			log.info(StatickInitializerBlock.AREA_MSG_OUTPUT,area);
		} else {
			log.error(StatickInitializerBlock.EXCEPTION_MSG);
		}
	}

}
