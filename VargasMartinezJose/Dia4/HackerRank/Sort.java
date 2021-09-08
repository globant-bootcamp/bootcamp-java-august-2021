package bootcamp.collections.com;

public class Sort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(numberOfStudents.nextLine());
		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = numberOfStudents.nextInt();
			String firstName = numberOfStudents.next();
			double averageGrades = numberOfStudents.nextDouble();
			Student studentRecord = new Student(id, firstName, averageGrades);
			studentList.add(studentRecord);
			testCases--;
		}
		studentList.sort((studentOne, studentTwo) -> studentOne.getId() - studentTwo.getId());
		studentList.sort((studentOne, studentTwo) -> studentOne.getFirstName().compareTo(studentTwo.getFirstName()));
		studentList.sort((Comparator.comparing(Student::getCgpa)).reversed());
		for (Student studentRecord : studentList) {
			System.out.println(studentRecord.getFname());
		}
	}
}
