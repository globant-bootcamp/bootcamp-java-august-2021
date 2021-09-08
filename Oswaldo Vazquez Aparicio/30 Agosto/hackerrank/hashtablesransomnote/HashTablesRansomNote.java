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

        List<String> magazineList = Arrays.asList(bufferedReader.readLine().replaceAll(regex, "").split(blankSpace));

        List<String> noteList = Arrays.asList(bufferedReader.readLine().replaceAll(regex, "").split(blankSpace));

        Result.checkMagazine(magazineList, noteList);

        bufferedReader.close();
    }

}