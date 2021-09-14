package challenges;

import challenges.solutions.FirstSolution;
import challenges.solutions.SecondSolution;
import challenges.solutions.ThirdSolution;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2

public class Main {

    public static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {

        String firstChallengeMessage = "FIRST CHALLENGE SOLUTION: ";
        log.info(firstChallengeMessage);
        FirstSolution.solve();
        String secondChallengeMessage = "SECOND CHALLENGE SOLUTION";
        log.info(secondChallengeMessage);
        SecondSolution.solve();
        String thirdChallengeMessage = "THIRD CHALLENGE SOLUTION";
        log.info(thirdChallengeMessage);
        ThirdSolution.solve();

    }
}


