package com.mycompany.javacollections;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public static void checkMagazine(List<String> magazine, List<String> note, int numberMagazineWords, int numberNoteWords) {
        int counter = 0;
        if (magazine.size() != numberMagazineWords || note.size() != numberNoteWords) {
            System.out.println("Sorry, the integer number isn't the number of words you give as input");
        } else {
            if (note.size() > magazine.size()) {
                System.out.println("No");
            } else {
                for (String word : note) {
                    if (magazine.contains(word)) {
                        magazine.remove(word);
                        counter += 1;
                    } else {
                        System.out.println("No");
                    }
                }
            }
            if (counter == note.size()) {
                System.out.println("Yes");
            }
        }
    }

    public static void queryResult(List<List<Integer>> columns, List<List<Integer>> queries) {
        queries.forEach(query -> {
            try {
                System.out.println(columns.get(query.get(0)).get(query.get(1)));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        });
    }
    
    public static void insertToList(List<String> values, int position, int valueToAdd){
        values.add(position, String.valueOf(valueToAdd));
    }
    
    public static void deleteFromList(List<String> values, int positionToDelete){
        values.remove(positionToDelete);
    }

}
