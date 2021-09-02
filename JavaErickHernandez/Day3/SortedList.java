package bootcamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SortedList {
	final static String numberOfInputs = "Enter the number of Students: ";
	final static String tryAgainMessage = "Try Again";
	final static String enterName = "Enter name: ";
	final static String enterId = "Enter id: ";
	final static String enterPoints = "Enter points: ";
	final static String error = "Error!";
	final static List<Student> studentList = new ArrayList<Student>();

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
			System.out.println(enterPoints);
			double points = 0.0;
			do {
				points = isDoubleNumber();
			} while (points <= 0 && points > 4);
			Student student = new Student(id, name, points);
			boolean exist = existStudent(student);
			if (!exist) {
				studentList.add(student);
			} else {
				System.out.println(tryAgainMessage);
				i--;
			}
		}
		sortStudents();
	}

	static void sortStudents() {
		studentList.sort(
				Comparator.comparing(Student::getPoints, Comparator.reverseOrder()).thenComparing(Student::getName));
		for (Student student : studentList) {
			System.out.println(student.name + " " + student.points);
		}
	}

	static boolean existStudent(Student student) {
		boolean exist = studentList.stream().anyMatch(o -> o.getId() == student.id);
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
