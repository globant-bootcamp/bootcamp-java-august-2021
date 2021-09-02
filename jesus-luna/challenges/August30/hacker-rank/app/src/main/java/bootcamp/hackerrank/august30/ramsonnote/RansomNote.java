package bootcamp.hackerrank.august30.ramsonnote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import bootcamp.hackerrank.Solution;

public class RansomNote extends Solution {

	private static final String ERROR_MSG = "Something happened during the process: %s";
	private static final String INPUTS_SIZE_INSTRUCTIONS = "Give magazine's size words, and note's size words: ";
	private static final String INPUT_MAGAZINE_WORDS_INSTRUCTIONS = "Give %d space-separated strings for the magazine words, words lenght 1-5 letters: ";
	private static final String INPUT_NOTE_WORDS_INSTRUCTIONS = "Give %d space-separated strings for the note words, words lenght 1-5 letters: ";
	private static final String NOTE_CREATED = "Note can be created";
	private static final String NOTE_NO_CREATED = "Sorry, the note can´t be created";
	
	private Optional<List<Object>> coincidences;
	private List<String> magazineWords;
	private List<String> noteWords;
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public void solve() {
		try {
			constraintInput();
			boolean availableNote = createNote();
			System.out.println((availableNote) ? RansomNote.NOTE_CREATED : RansomNote.NOTE_NO_CREATED);
		} catch (IOException e) {
			System.out.println(String.format(RansomNote.ERROR_MSG, e.getMessage()));
		}
	}
	
	private void constraintInput() throws IOException {
    String regexInputNumberOfWords = "([1|2][\\d]{0,4}|[1-9][\\d]{0,3}|30000)";
    String regexInputNoteMagazineFormat = "[a-zA-Z]{1,5}";
    String instructionsFormat;
    int magazineWordsSize;
    int noteWordsSize;
    Pattern pat;
    
    pat = Pattern.compile(regexInputNumberOfWords);    
    readValidInput(RansomNote.INPUTS_SIZE_INSTRUCTIONS, 2, pat);
    magazineWordsSize = Integer.parseInt(coincidences.get().get(0).toString());
    noteWordsSize = Integer.parseInt(coincidences.get().get(1).toString());

		pat = Pattern.compile(regexInputNoteMagazineFormat);
		instructionsFormat = String.format(RansomNote.INPUT_MAGAZINE_WORDS_INSTRUCTIONS, magazineWordsSize);
		readValidInput(instructionsFormat, magazineWordsSize, pat);
		magazineWords = coincidences.get()
				.subList(0, magazineWordsSize)
				.stream()
				.map(Object::toString)
				.collect(Collectors.toList());
				
		instructionsFormat = String.format(RansomNote.INPUT_NOTE_WORDS_INSTRUCTIONS, noteWordsSize);
		readValidInput(instructionsFormat, noteWordsSize, pat);
		noteWords = coincidences.get()
				.subList(0, noteWordsSize)
				.stream()
				.map(Object::toString)
				.collect(Collectors.toList());
		
		bufferedReader.close();
	}
	
	private void readValidInput(String instructions, int minimumCoincidences, Pattern pattern) throws IOException {
		String input;
		Matcher mat;
		do {
			System.out.print(instructions);
			input = bufferedReader.readLine().trim();
			mat = pattern.matcher(input);
			coincidences = this.getCoincidences(mat);
			
		} while (coincidences.isEmpty() || coincidences.get().size() < minimumCoincidences);
	}
	
	private Optional<List<Object>> getCoincidences(Matcher mat){
		List<Object> listWithCoincidences = new ArrayList<>();
		while(mat.find()) {
		    listWithCoincidences.add(mat.group(0));
		}	
		return Optional.ofNullable(listWithCoincidences);
	}
	
	private boolean createNote() {
		Map<String, Integer> magazineRelationWords = magazineWords.stream().collect(Collectors.toMap(Function.identity(), word -> Collections.frequency(magazineWords, word)));
		Map<String, Long> noteRelationWords = noteWords.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		for (Entry<String, Long> entry : noteRelationWords.entrySet()) {
			String noteWord = entry.getKey();
			Long noteWordFrequency = entry.getValue();
			boolean magazineHasNoteWord = magazineRelationWords.containsKey(noteWord);
			boolean noteWordFrequencyGreaterThanMagazine = (magazineHasNoteWord) ? noteWordFrequency > magazineRelationWords.get(noteWord) : true;
			if(!magazineHasNoteWord || noteWordFrequencyGreaterThanMagazine) {
				return false;
			}
		}
		return true;
	}
}
