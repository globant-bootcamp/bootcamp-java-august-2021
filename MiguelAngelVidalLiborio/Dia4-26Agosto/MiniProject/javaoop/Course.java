package javaoop;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private List<Student> myStudents = new ArrayList<Student>();

	public void getStudent() {
		int lastElementFromList = myStudents.size() - 1;
		System.out.println(myStudents.get(lastElementFromList).studentName);
	}

	public void getStudent(int index) {
		System.out.printf("%-5s:%d", myStudents.get(index).studentName, myStudents.get(index).age);
	}

	public void setMeeting(String myMeeting) {
		System.out.println(myMeeting);
	}

	public void addStudent(Student student) {
		myStudents.add(student);
	}

	public List<Student> getStudents() {
		return myStudents;
	}

}
