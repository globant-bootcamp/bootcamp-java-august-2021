package hackerrank3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class JavaHashTable {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		List<String> magazine = new ArrayList<String>();
		List<String> note = new ArrayList<String>();
    String[] elements = sc.nextLine().split(" ");
    int elementsMagazine = Integer.parseInt(elements[0]);
    int elementsNote =  Integer.parseInt(elements[1]);
    String[] magazineWords  = sc.nextLine().split(" ");
    String[] noteWords  = sc.nextLine().split(" ");
    for(int i = 0; i < elementsMagazine; i++){
    	magazine.add(magazineWords[i]);
    }
    for(int i = 0; i < elementsNote; i++){
    	note.add(noteWords[i]);
    }
    Result.checkMagazine(magazine, note);
    sc.close();
	}
}

class Result {
	public static void checkMagazine(List<String> magazine, List<String> note) {
		Hashtable<String,Integer> containerNote = new Hashtable<String,Integer>();
		Hashtable<String,Integer> containerMagazine = new Hashtable<String,Integer>();
		for(int i = 0; i < note.size(); i++) {
			if(containerNote.containsKey(note.get(i))){
				containerNote.put(note.get(i), containerNote.get(note.get(i))+1);
			}else{
				containerNote.put(note.get(i),1);
				containerMagazine.put(note.get(i),0);
			}
		}
		for(int i = 0; i < magazine.size(); i++){
			if(containerMagazine.containsKey(magazine.get(i))){
				containerMagazine.put(magazine.get(i), containerMagazine.get(magazine.get(i)) + 1);
			}
		}
		if(containerNote.equals(containerMagazine)) {
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
}
