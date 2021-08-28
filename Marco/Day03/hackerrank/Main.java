package hackerrank;

import hackerrank.solutions.Bird;
import hackerrank.solutions.Two;
import hackerrank.solutions.Third;

public class Main {
    public static void main(String[] args) {

        String firstSolutionEntrance, secondSolutionEntrance,thirdSolutionEntrance;

        Bird bird = new Bird();
        firstSolutionEntrance = "The bird goes...";
        System.out.println(firstSolutionEntrance);
        bird.fly();
        bird.walk();
        bird.sing();

        Two secondSolution = new Two();
        secondSolutionEntrance = "Doing maths...";
        System.out.println(secondSolutionEntrance);
        Two.resolve();

        Third thirdSolution = new Third();
        thirdSolutionEntrance = "Just enter a string followed by a integer: ";
        System.out.println(thirdSolutionEntrance);
        Third.solving();

    }
}
