package javasort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int elements = Integer.parseInt(scanner.nextLine());
		List<Student> studentList = new ArrayList<Student>();
		while (elements > 0) {
			int id = scanner.nextInt();
			String name = scanner.next();
			double average = scanner.nextDouble();
			Student student = new Student(id, name, average);
			studentList.add(student);
			elements--;
		}
		Collections.sort(studentList, Collections.reverseOrder());
		for (Student student : studentList) {
			System.out.println(student.getName());
		}
		scanner.close();
	}
}
