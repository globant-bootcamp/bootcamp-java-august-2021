
package collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTables {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int magazineLength = in.nextInt();
        int noteLength = in.nextInt();
        List<String> magazine = new ArrayList<>();
        for (int magazineIndex = 0; magazineIndex < magazineLength; magazineIndex++) {
             String word = in.next();
             magazine.add(word);
        }
         List<String> note = new ArrayList<>();
        for (int noteIndex = 0; noteIndex < noteLength; noteIndex++){
            String word = in.next();
            note.add(word);
        }
        System.out.println(ResultHashTables.checkMagazine(magazine, note)?"Yes":"No"); 
    }
}
