
package collection;

public class ResultHashTables {
    static boolean checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineWords = new HashMap<String, Integer>();
        for (int indiceMagazine = 0; indiceMagazine < magazine.length; indiceMagazine++) {
            Integer wordCount = magazineWords.get(magazine[indiceMagazine]);
            if (wordCount == null) {
                magazineWords.put(magazine[indiceMagazine], 1);
            } else {
                magazineWords.put(magazine[indiceMagazine], wordCount + 1);
            }
        }
        for (int note_index = 0; note_index < note.length; note_index++) {
            Integer founWord = magazineWords.get(note[note_index]);
            if (founWord == null || founWord == 0) {
                return false;
            } else {
                magazineWords.put(note[note_index], founWord - 1);
            }
        }
        return true;
    }
}
