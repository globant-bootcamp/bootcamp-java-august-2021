package RansomNote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int magazineSize = in.nextInt();
        int noteSize = in.nextInt();

        List<String> magazine = new ArrayList<>();

        for (int magazineIndex = 0; magazineIndex < magazineSize; magazineIndex++) {
            String word = in.next();
            magazine.add(word);
        }

        List<String> note = new ArrayList<>();

        for (int noteIndex = 0; noteIndex < noteSize; noteIndex++){
            String word = in.next();
            note.add(word);
        }

        RansomeNote.checkMagazine(magazine, note);
    }
}
