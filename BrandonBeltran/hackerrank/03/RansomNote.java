package bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class Result {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        HashMap<String, Integer> magazineWords = new HashMap<>();

        for(String word: magazine){
            if(magazineWords.containsKey(word)){
                magazineWords.replace(word, magazineWords.get(word)+1);
            }else{
                magazineWords.put(word, 1);
            }
        }

        String doable = "Yes";

        for(String word: note){
            if(magazineWords.containsKey((word)) && magazineWords.get(word) > 0){
                magazineWords.put(word, magazineWords.get(word)-1);
            }else{
                doable = "No";
                break;
            }
        }
        System.out.println(doable);
    }

}

public class RansomNote {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] totalWords = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int magazineTotalWords = Integer.parseInt(totalWords[0]);
        int noteTotalWords = Integer.parseInt(totalWords[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        if(magazineTotalWords > noteTotalWords){
            Result.checkMagazine(magazine, note);
        }else{
            System.out.println("No");
        }

        bufferedReader.close();
    }
}
