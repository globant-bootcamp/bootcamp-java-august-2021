package javaoop;

public class Main {

	public static void main(String[] args) {
		Course myCourse = new Course();
		myCourse.welcome();
		myCourse.welcome("heey whats up");

		System.out.println("");
		Backend backend = new Backend();
		backend.welcome();
		backend.setMeeting("Teams");
		backend.addStudent(new Student("Miguel Angel Vidal Liborio", 24));
		backend.addStudent(new Student("Antonio Perez Landa", 21));
		backend.addStudent(new Student("Maria Mercedes", 25));
		backend.getStudents().forEach(student -> System.out.println(student.studentName + " - " + student.age));

		System.out.println("");
		Frontend frontend = new Frontend();
		frontend.welcome();
		frontend.setMeeting("Zoom");
		frontend.addStudent(new Student("Juan Romero", 17));
		frontend.getStudents().forEach(student -> System.out.println(student.studentName + " - " + student.age));

	}

}
