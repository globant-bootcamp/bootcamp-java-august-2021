package com.mycompany.javacollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionHashSet {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numInputs = Integer.valueOf(bufferedReader.readLine());
        Set<List> hashSet = new HashSet<>();
        for (int point = 0; point < numInputs; point++) {
            List<String> names = new ArrayList<>(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
            if (names.get(0).length() > 5 || names.get(1).length() > 5) {
                System.out.println("Words can not have more than 5 letters");
            } else {
                hashSet.add(names);
            }
            System.out.println(hashSet.size());
        }
    }
}
