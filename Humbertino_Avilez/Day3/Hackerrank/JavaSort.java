package hackerrank3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int elements = Integer.parseInt(sc.nextLine());
		List<Student> studentList = new ArrayList<Student>();
		while (elements > 0) {
			int id = sc.nextInt();
			String fname = sc.next();
			double cgpa = sc.nextDouble();
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			elements--;
		}
		Collections.sort(studentList,Collections.reverseOrder());
		for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}

class Student implements Comparable<Object> {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public int compareTo(Object o) {
		Student student = (Student) o;
		if(Double.compare(this.cgpa, student.cgpa) == 0) {
			if(this.fname.compareTo(student.fname) == 0) {
				return this.id - student.id;
			}else {
				return this.fname.compareTo(student.fname);
			}
		}else{
			return Double.compare(this.cgpa, student.cgpa);
		}
	}
}
