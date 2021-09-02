package hackerrank.day4;

import hackerrank.day4.currencyformatter.ExerciseFormatter;
import hackerrank.day4.staticblock.ExerciseStaticInitializer;
import hackerrank.day4.tostring.ExerciseJavaToString;
import lombok.extern.log4j.Log4j2;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 01/09/21
 */
@Log4j2
public class HackerRankExercisesDay4 {
    public static void main(String[] args) {
        log.info("Exercise Java Int to String: ");
        ExerciseFormatter.getCountryFormat();
        log.info("Exercise Java Static Initializer Block: ");
        ExerciseStaticInitializer.getAreaParallelogram();
        log.info("Exercise Java Int to String");
        ExerciseJavaToString.getParseInteger();
    }
}
