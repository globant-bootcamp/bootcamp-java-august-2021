package collections.hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class JavaHashTablesRansomNote {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    final String CAN_BE_FORMED = "Yes";
    final String CAN_NOT_BE_FORMED = "No";

    List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .collect(toList());

    List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .collect(toList());

    if (CheckMagazine.checkMagazine(magazine, note)) {
      System.out.println(CAN_BE_FORMED);
    } else {
      System.out.println(CAN_NOT_BE_FORMED);
    }

    bufferedReader.close();
  }
}

// Challenge: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
