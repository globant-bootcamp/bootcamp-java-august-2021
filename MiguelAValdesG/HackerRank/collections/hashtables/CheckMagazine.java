package collections.hashtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckMagazine {

  public static boolean checkMagazine(List<String> magazine, List<String> note) {
    Map<String, Integer> wordsInMagazine = new HashMap<>();
    Map<String, Integer> wordsInNote = new HashMap<>();
    final Integer INIT_VALUE = 0;
    final Integer ONE = 1;
    final boolean CAN_BE_FORMED = true;
    final boolean CAN_NOT_BE_FORMED = false;

    for (String word : magazine) {
      if (!wordsInMagazine.containsKey(word)) {
        wordsInMagazine.put(word, INIT_VALUE);
      }
      Integer occurrences = wordsInMagazine.get(word);
      wordsInMagazine.put(word, occurrences + ONE);
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
