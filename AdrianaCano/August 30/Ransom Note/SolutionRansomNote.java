package com.mycompany.javacollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionRansomNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int numberMagazineWords = Integer.parseInt(firstMultipleInput[0]);
        int numberNoteWords = Integer.parseInt(firstMultipleInput[1]);
        List<String> magazine = new ArrayList<>(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        List<String> note = new ArrayList<>(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        int sizeMagazine = magazine.size();
        int sizeNote = note.size();
        Result.checkMagazine(magazine, note, numberMagazineWords, numberNoteWords);
        bufferedReader.close();
    }
}
