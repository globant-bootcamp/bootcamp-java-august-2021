
package collection;

public class Hashset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        String[] left = new String[lines];
        String[] right = new String[lines];
        for (int indicePair = 0; indicePair < lines; indicePair++) {
            left[indicePair] = in.next();
            right[indicePair] = in.next();
        }
        HashSet<String> pairs = new HashSet<>(lines);
        for (int countPair = 0; countPair < lines; countPair++) {
            pairs.add(left[countPair] + "," + right[countPair] );
            System.out.println(pairs.size());
        }
    }
}
