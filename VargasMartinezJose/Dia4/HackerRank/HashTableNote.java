package bootcamp.collections.com;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class HashTableNote {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineWords = new HashMap<>();
        for (String word : magazine) {
            String key = word;
            int count = magazineWords.getOrDefault(key, 0);
            magazineWords.put(key, count + 1);
        }
        for (String word : note) {
            if (magazineWords.containsKey(word)) {
                int count = magazineWords.get(word);
                if (count <= 0) {
                    System.out.println("No");
                    return;
                }
                count--;
                magazineWords.put(word, count);
            } else{
                System.out.println("No");
                return;
            }
        }
        System.out.print("Yes");
     }
}