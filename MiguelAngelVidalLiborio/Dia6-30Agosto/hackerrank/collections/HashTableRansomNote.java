package collections;

import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class HashTableRansomNote {

	public static final String REGEX_BUFFER_READER = "\\\\s+$";
	public static final String BLANK_SPACE = "";

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll(BLANK_SPACE, REGEX_BUFFER_READER)
				.split(BLANK_SPACE);

		int magazineWords = Integer.parseInt(firstMultipleInput[0]);

		int noteWords = Integer.parseInt(firstMultipleInput[1]);

		List<String> magazine = Stream
				.of(bufferedReader.readLine().replaceAll(BLANK_SPACE, REGEX_BUFFER_READER).split(BLANK_SPACE))
				.collect(Collectors.toList());

		List<String> note = Stream
				.of(bufferedReader.readLine().replaceAll(BLANK_SPACE, REGEX_BUFFER_READER).split(BLANK_SPACE))
				.collect(Collectors.toList());

		if (magazineWords > noteWords) {
			ResultHashTableRansom.checkMagazine(magazine, note);
		} else {
			System.out.println("NO");
		}

		bufferedReader.close();

	}
}
