import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
	private int id;
	private String firstName;
	private double score;

	public Student(int id, String firstName, double score) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getScore() {
		return score;
	}
}

public class Solution
{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();

		while(testCases>0){

			int id = in.nextInt();
			String firstName = in.next();
			double score = in.nextDouble();
			
			Student newStudent = new Student(id, firstName, score);
			studentList.add(newStudent);
			
			testCases--;
		}
      
        Collections.sort(studentList,  Comparator.comparing(Student :: getScore).reversed().thenComparing(Student :: getFirstName).thenComparing(Student :: getId));
         
        for(Student st: studentList){
			System.out.println(st.getFname());
		}

	}

}



