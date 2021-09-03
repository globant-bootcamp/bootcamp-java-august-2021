package bootcamp.hackerrank.august30.sort;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import bootcamp.hackerrank.Solution;

public class ReArrange extends Solution {

	private static final String NUMBER_STUDENTS_INPUT_INSTRUCTIONS = "Give the number of students: ";
	private static final String NUMBER_STUDENTS_INPUT_INVALID = "The expected value is a number between 2 - 1000";
	private static final String ID_INPUT_INSTRUCTIONS = "Give the ID of the student : ";
	private static final String ID_INPUT_INVALID = "The expected value is a number between 0 - 10000";
	private static final String CGPA_INPUT_INSTRUCTIONS = "Give the CGPA of the student : ";
	private static final String CGPA_FORMAT_INPUT = "([0-3]{1}\\.[0-9]{2,}|4.00)";
	private static final String CGPA_INPUT_INVALID = "The expected value is a number between 0.00 - 4.00 and will contain, at most, 2 digits after the decimal point.";
	private static final String NAME_INPUT_INSTRUCTIONS = "Give the name of the student : ";
	private static final String NAME_INPUT_INVALID = "The expected value is a string with a length between 5 - 30";

	@Override
	public void solve() {
		createStudentsList();
	}

	private void createStudentsList() {
		int numberOfStudents;
		int idStudent;
		double cgpa;
		String name;
		numberOfStudents = readNumberOfStudentsRecursive();
		List<Student> listOfStudents = new ArrayList<>();
		for (int index = 0; index < numberOfStudents; index++) {
			idStudent = readIdStudent();
			cgpa = readCgpa();
			name = readName();
			listOfStudents.add(new Student(idStudent, name, cgpa));
		}
		listOfStudents.forEach(s->System.out.println(s.toString()));
	}
	
	private int readNumberOfStudentsIteration() {
		boolean validValue = true;
		int numberOfStudents;		
		do {
				numberOfStudents = readIntegerInput(ReArrange.NUMBER_STUDENTS_INPUT_INSTRUCTIONS);
				validValue = true;
				if(numberOfStudents < 2 || numberOfStudents > 10000) {
					System.out.println(ReArrange.NUMBER_STUDENTS_INPUT_INVALID);
					validValue = false;
				}
		} while (!validValue);
		return numberOfStudents;
	}
	
	private int readNumberOfStudentsRecursive() {
		int numberOfStudents;
		numberOfStudents = readIntegerInput(ReArrange.NUMBER_STUDENTS_INPUT_INSTRUCTIONS);
		if(numberOfStudents < 2 || numberOfStudents > 10000) {
			System.out.println(ReArrange.NUMBER_STUDENTS_INPUT_INVALID);
			numberOfStudents = readNumberOfStudentsRecursive();
		}
		return numberOfStudents;
	}
	
	private int readIdStudent() {
		int idStudent;
		idStudent = readIntegerInput(ReArrange.ID_INPUT_INSTRUCTIONS);
		if(idStudent < 0 || idStudent > 100000) {
			System.out.println(ReArrange.ID_INPUT_INVALID);
			idStudent = readIdStudent();
		}
		return idStudent;
	}
	
	private double readCgpa() {
		double cgpa;
		cgpa = readDoubleInput(ReArrange.CGPA_INPUT_INSTRUCTIONS);
		boolean cgpaFormat = String.valueOf(cgpa).matches(ReArrange.CGPA_FORMAT_INPUT);
		if(cgpa < 0 || cgpa > 4.00 | !cgpaFormat) {
			System.out.println(ReArrange.CGPA_INPUT_INVALID);
			cgpa = readCgpa();
		}
		return cgpa;
	}
	
	private String readName() {
		String name;
		System.out.println(ReArrange.NAME_INPUT_INSTRUCTIONS);
		Solution.scanner.nextLine();
		name = Solution.scanner.nextLine().toLowerCase();
		if(name.length() < 5 || name.length() > 30) {
			System.out.println(ReArrange.NAME_INPUT_INVALID);
			
			name = readName();
		}
		return name;
	}
	
	private int readIntegerInput(String instruction) {
		int intInput;
		try {
			System.out.print(instruction);
			intInput = Solution.scanner.nextInt();
		} catch (InputMismatchException e) {
			Solution.scanner.nextLine();
			intInput = readIntegerInput(instruction);
		}
		return intInput;
	}
	
	private double readDoubleInput(String instruction) {
		double doubleInput;
		try {
			System.out.print(instruction);
			doubleInput = Solution.scanner.nextDouble();
		} catch (InputMismatchException e) {
			Solution.scanner.nextLine();
			doubleInput = readDoubleInput(instruction);
		}
		return doubleInput;
	}
	

}
