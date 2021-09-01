package com.bootcamp.daythree.hackerrank.hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HashTableExercise {

    public static final String WHITE_SPACES = "\\s+$";
    public static final String SPACE = " ";
    public static final String WITHOUT_SPACE = "";
    public static final String NO = "No";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll(WHITE_SPACES, WITHOUT_SPACE).split(SPACE);

        int magazineWords = Integer.parseInt(firstMultipleInput[0]);

        int noteWords = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll(WHITE_SPACES, WITHOUT_SPACE).split(SPACE))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll(WHITE_SPACES, WITHOUT_SPACE).split(SPACE))
                .collect(toList());

        if (magazineWords > noteWords) {
            Result.checkMagazine(magazine, note);
        } else {
            System.out.println(NO);
        }

        bufferedReader.close();
    }
}