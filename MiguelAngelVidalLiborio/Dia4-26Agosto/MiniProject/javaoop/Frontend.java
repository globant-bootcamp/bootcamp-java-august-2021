package javaoop;

import java.util.List;

public class Frontend extends Course {

	public void welcome() {
		System.out.println("Welcome to ReactJs Course");
	}

	@Override
	public void setMeeting(String myMeeting) {
		super.setMeeting("Frontend: " + myMeeting);
	}

	@Override
	public void addStudent(Student student) {
		super.addStudent(student);
	}

	@Override
	public List<Student> getStudents() {
		return super.getStudents();
	}

}
