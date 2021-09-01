package hackerrank.day3;

import hackerrank.day3.arraylist.ExerciseArraylist;
import hackerrank.day3.hashset.ExerciseHashset;
import hackerrank.day3.list.ExerciseList;
import hackerrank.day3.map.ExerciseMap;
import hackerrank.day3.ransom.ExerciseRansom;
import hackerrank.day3.sort.ExcerciseSort;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */
public class HackerRankExercisesDay3 {

    public static void main(String[] args) {
        System.out.println("Exercise Sort: ");
        ExcerciseSort.getScanInfoStudents();
        System.out.println("Exercise Hashset: ");
        ExerciseHashset.getScanNames();
        System.out.println("Exercise Map: ");
        ExerciseMap.getScanDirectory();
        System.out.println("Exercise List: ");
        ExerciseList.getListInfo();
        System.out.println("Exercise Arraylist: ");
        ExerciseArraylist.getArrayInfo();
        System.out.println("Exercise Ransom: ");
        ExerciseRansom.getWordsMagazine();

    }
}
