package challenge;

import java.util.Scanner;
import challenge.solutions.*;

public class Main {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();

        System.out.println("Running the first problem solution.\n");
        solution1.firstSolution();

        System.out.println("Running the second problem solution.\n");
        solution2.secondSolution();

        System.out.println("Running the third problem solution.\n");
        solution3.thirdSolution();
        scan.close();

    }
}
