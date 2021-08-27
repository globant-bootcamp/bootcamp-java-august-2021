package javaoop;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private static final String COMPANY = "Globant";
	private List<Student> myStudents = new ArrayList<Student>();

	public void welcome() {
		System.out.println("Welcome to: " + COMPANY);
	}

	public void welcome(String greeting) {
		System.out.println(greeting);
	}

	public void setMeeting(String myMeeting) {
		System.out.println(myMeeting);
	}

	public void addStudent(Student student) {
		this.myStudents.add(student);
	}

	public List<Student> getStudents() {
		return this.myStudents;
	}

}
