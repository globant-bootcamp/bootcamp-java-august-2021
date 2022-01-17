package challenges.collections;

import java.util.*;

class Student {
	private int id;
	private String name;
	private double cgpa;

	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}
}

public class SolutionSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());

		List<Student> studentsList = new ArrayList<Student>();
		while (testCases > 0){
			int id = scanner.nextInt();
			String name = scanner.next();
			double cgpa = scanner.nextDouble();

			Student student = new Student(id, name, cgpa);
			studentsList.add(student);

			testCases--;
		}

		Collections.sort(studentsList, Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));
		for (Student student : studentsList) {
			System.out.println(student.getName());

		}

	}

}
