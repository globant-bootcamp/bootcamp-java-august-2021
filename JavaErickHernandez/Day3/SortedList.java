package bootcamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SortedList {
	static String numberOfInputs = "Enter the number of Students: ";
	static String tryAgainMessage = "Try Again";
	static String enterName = "Enter name: ";
	static String enterId = "Enter id: ";
	static String enterCGPA = "Enter CGPA: ";
	static String error = "Error!";
	static ArrayList<Student> students = new ArrayList<Student>();

	public static void numberOfInputs() {
		System.out.println(numberOfInputs);
		int studentsCount;
		do {
			studentsCount = isNumber();
		} while (studentsCount <= 0 && studentsCount >= 100000);
		fillStudent(studentsCount);
	}

	private static void fillStudent(int pairNumbers) {
		for (int i = 1; i <= pairNumbers; i++) {
			System.out.println(enterName);
			Scanner scanner = new Scanner(System.in);
			String name;
			do {
				name = scanner.next();
			} while (name.length() < 5 && name.length() > 30);
			System.out.println(enterId);
			int id;
			do {
				id = isNumber();
			} while (id <= 0 && id >= 100000);
			System.out.println(enterCGPA);
			double cgpa = 0.0;
			do {
				cgpa = isDoubleNumber();
			} while (cgpa <= 0 && cgpa > 4);
			Student student = new Student(id, name, cgpa);
			boolean exist = existStudent(student);
			if (!exist) {
				students.add(student);
			} else {
				System.out.println(tryAgainMessage);
				i--;
			}
		}
		sortStudents();
	}

	static void sortStudents() {
		students.sort(
				Comparator.comparing(Student::getCgpa, Comparator.reverseOrder()).thenComparing(Student::getName));
		for (Student student : students) {
			System.out.println(student.name + " " + student.cgpa);
		}
	}

	static boolean existStudent(Student student) {
		boolean exist = students.stream().anyMatch(o -> o.getId() == student.id);
		return exist;
	}

	static int isNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			boolean nextStep;
			try {
				String number = scanner.next();
				Integer.parseInt(number);
				nextStep = true;
				return Integer.parseInt(number);
			} catch (Exception e) {
				System.out.println(tryAgainMessage);
			}
		} while (!false);
	}

	static double isDoubleNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			boolean nextStep;
			try {
				String number = scanner.next();
				Double.parseDouble(number);
				nextStep = true;
				return Double.parseDouble(number);
			} catch (Exception e) {
				System.out.println(tryAgainMessage);
			}
		} while (!false);
	}
}
