package hackkerank.day3.ransomNote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int magazine = Integer.parseInt(firstMultipleInput[0]);

        int note = Integer.parseInt(firstMultipleInput[1]);

        bufferedReader.close();
    }
}
