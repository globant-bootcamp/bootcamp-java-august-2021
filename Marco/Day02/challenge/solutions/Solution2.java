package challenge.solutions;

import challenge.Main;

public class Solution2 {

    public void secondSolution() {

        System.out.println("Enter a number to check its weirdness:");
        int weird_number = Main.scan.nextInt();
        Main.scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String weirdness;

        if ((weird_number % 2) == 0) {

            if ((weird_number > 5) && (weird_number <= 20)) {
                weirdness = "Weird";
            } else {
                weirdness = "Not Weird";
            }
        } else {
            weirdness = "Weird";
        }

        System.out.println(weirdness);
    }
}
