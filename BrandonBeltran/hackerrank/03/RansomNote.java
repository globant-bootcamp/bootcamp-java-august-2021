package bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class RansomNote {

    public static final String WHITESPACE_AND_EOL = "\\s+$";

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] totalWords = bufferedReader.readLine().replaceAll(WHITESPACE_AND_EOL, "").split(" ");

        int magazineTotalWords = Integer.parseInt(totalWords[0]);
        int noteTotalWords = Integer.parseInt(totalWords[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll(WHITESPACE_AND_EOL, "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll(WHITESPACE_AND_EOL, "").split(" "))
                .collect(toList());

        if(magazineTotalWords > noteTotalWords){
            RandomNoteSolve.checkMagazine(magazine, note);
        }else{
            System.out.println("No");
        }

        bufferedReader.close();
    }

}
