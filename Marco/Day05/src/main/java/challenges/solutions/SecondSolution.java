package challenges.solutions;

import challenges.Main;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class SecondSolution {
    public static void solve() {

        String numberPetition="Enter an integer: ";
        log.info(numberPetition);
        int n = Main.SCAN.nextInt();
        String s = Integer.toString(n);

        if (n == Integer.parseInt(s)) {
            log.info("Good job");
        } else {
            log.info("Wrong answer.");
        }
    }
}
