package hackerrank;

import hackerrank.solutions.*;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();
        System.out.println("The bird goes...");
        bird.fly();
        bird.walk();
        bird.sing();

        Two secondSolution = new Two();
        System.out.println("Doing maths...");
        secondSolution.resolve();

        Third thirdSolution = new Third();
        System.out.println("Just enter a string followed by a integer: ");
        thirdSolution.solving();
    }
}
