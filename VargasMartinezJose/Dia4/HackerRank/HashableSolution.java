package bootcamp.collections.com;

public class HashableSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());
        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList());
        Result.checkMagazine(magazine, note);
        bufferedReader.close();
    }
}
