package hackerrank.hashtablesransomnote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class HashTablesRansomNote {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "\\s+$";
        String blankSpace = " ";
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll(regex, "").split(blankSpace);

        List<String> magazine = Arrays.asList(bufferedReader.readLine().replaceAll(regex, "").split(blankSpace));

        List<String> note = Arrays.asList(bufferedReader.readLine().replaceAll(regex, "").split(blankSpace));

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }

}