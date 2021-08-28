package javaoop;

import java.util.List;

public class Backend extends Course {

	@Override
	public void getStudent() {
		super.getStudent();
	}

	@Override
	public void getStudent(int index) {
		super.getStudent(index);
	}

	@Override
	public void setMeeting(String myMeeting) {
		super.setMeeting("are you ready?, Backend: " + myMeeting);
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
