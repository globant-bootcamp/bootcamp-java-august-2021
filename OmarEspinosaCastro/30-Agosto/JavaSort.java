
package collection;

public class JavaSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberStudent  = Integer.parseInt(in.nextLine());
        ArrayList<Student> studentList = new ArrayList<Student>();
        while (numberStudent > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
            numberStudent--;
        }
        Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getFname).thenComparing(Student::getId));
        for (Student student : studentList) {
            System.out.println(student.getFname());
        }
    }
}
