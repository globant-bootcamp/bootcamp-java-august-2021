package bootcamp.hackerrank.august30.sort;

import java.util.InputMismatchException;

import bootcamp.hackerrank.Solution;

public class ReArrange extends Solution {

	private static final String NUMBER_STUDENTS_INPUT_INSTRUCTIONS = "Give the number of students: ";
	private static final String NUMBER_STUDENTS_INPUT_INVALID = "The expected value is a number between 2 - 1000";
	private static final String NUMBER_ID_INPUT_INSTRUCTIONS = "Give the ID of the student : ";
	private static final String NUMBER_ID_INPUT_INVALID = "The expected value is a number between 0 - 10000";

	@Override
	public void solve() {
		createStudentsList();
	}

	private void createStudentsList() {
		boolean validValue = true;
		int numberOfStudents;
		int idStudent;
		numberOfStudents = readNumberOfStudentsIteration();
		
		for (int index = 0; index < numberOfStudents; index++) {
			
		}
	}
	
	private int readNumberOfStudentsIteration() {
		boolean validValue = true;
		int numberOfStudents;		
		do {
				numberOfStudents = readNumberInput(ReArrange.NUMBER_STUDENTS_INPUT_INSTRUCTIONS);
				validValue = true;
				System.out.println("The value introduced is "+numberOfStudents);
				if(numberOfStudents < 2 || numberOfStudents > 10000) {
					System.out.println("inside here");
					System.out.println(ReArrange.NUMBER_STUDENTS_INPUT_INVALID);
					validValue = false;
				}
		} while (!validValue);
		return numberOfStudents;
	}
	
	private int readNumberOfStudentsRecursive() {
		int numberOfStudents;
		numberOfStudents = readNumberInput(ReArrange.NUMBER_STUDENTS_INPUT_INSTRUCTIONS);
		if(numberOfStudents < 2 || numberOfStudents > 10000) {
			System.out.println(ReArrange.NUMBER_STUDENTS_INPUT_INVALID);
			numberOfStudents = readNumberOfStudentsRecursive();
		}
		return numberOfStudents;
	}

	private int readNumberInput(String instruction) {
		int intInput;
		try {
			System.out.print(instruction);
			intInput = Solution.scanner.nextInt();
		} catch (InputMismatchException e) {
			Solution.scanner.nextLine();
			intInput = readNumberInput(instruction);
		}
		return intInput;
	}
	
	

}
