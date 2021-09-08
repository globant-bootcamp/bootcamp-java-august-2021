package collections;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortExercise {
	public static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(SCANNER.nextLine());
		List<StudentSortExercise> studentList = new ArrayList<StudentSortExercise>();

		while (testCases > 0) {
			int id = SCANNER.nextInt();
			String firstName = SCANNER.next();
			double cgpa = SCANNER.nextDouble();

			StudentSortExercise student = new StudentSortExercise(id, firstName, cgpa);
			studentList.add(student);

			testCases--;
		}

		Collections.sort(studentList,
				(firstStudent, secondStudent) -> Comparator.comparing(StudentSortExercise::getCgpa).reversed()
						.thenComparing(StudentSortExercise::getFirstName).thenComparing(StudentSortExercise::getId)
						.compare(firstStudent, secondStudent));

		for (StudentSortExercise st : studentList) {
			System.out.println(st.getFirstName());
		}
		
	}
}
