import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  public static boolean checkMagazine(List<String> magazine, List<String> note) {
    HashMap<String, Integer> wordsInMagazine = new HashMap<>();
    HashMap<String, Integer> wordsInNote = new HashMap<>();
    final Integer INIT_VALUE = 0;
    final Integer ONE = 1;
    final boolean CAN_BE_FORMED = true;
    final boolean CAN_NOT_BE_FORMED = false;

    for (String word : magazine) {
      if (!wordsInMagazine.containsKey(word)) {
        wordsInMagazine.put(word, INIT_VALUE);
      }
      Integer wordConcurrences = wordsInMagazine.get(word);
      wordsInMagazine.put(word, wordConcurrences + ONE);
    }

    for (String word : note) {
      if (!wordsInNote.containsKey(word)) {
        wordsInNote.put(word, INIT_VALUE);
      }
      Integer wordConcurrences = wordsInNote.get(word);
      wordsInNote.put(word, wordConcurrences + ONE);
    }

    for (String key : wordsInNote.keySet()) {
      if (!wordsInMagazine.containsKey(key)) {
        return CAN_NOT_BE_FORMED;
      }

      int keyConcurrences = wordsInNote.get(key);
      if (wordsInMagazine.get(key) < keyConcurrences) {
        return CAN_NOT_BE_FORMED;
      }
    }

    return CAN_BE_FORMED;
  }
}

public class JavaHashTablesRansomNote {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    final String CAN_BE_FORMED = "Yes";
    final String CAN_NOT_BE_FORMED = "No";

    List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .collect(toList());

    List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .collect(toList());

    if (Result.checkMagazine(magazine, note)) {
      System.out.println(CAN_BE_FORMED);
    } else {
      System.out.println(CAN_NOT_BE_FORMED);
    }

    bufferedReader.close();
  }
}

// Challenge: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
