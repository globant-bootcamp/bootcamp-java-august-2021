public class Solution2 {

    public void secondSolution() {

        System.out.println("Enter a number to check its weirdness:");
        int N = Main.scan.nextInt();
        Main.scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String weirdness;

        if ((N % 2) == 0) {

            if ((N > 5) && (N <= 20)) {
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
