package hackerrank.day3.sort;

import java.util.Comparator;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 31/08/21
 */
public class StudentComparator implements Comparator<Student> {

    /**
     * Method of the Comparator interface, which does the logic of the comparison.
     */
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getCgpa() < student2.getCgpa()) {
            return 1;
        }
        if (student1.getCgpa() > student2.getCgpa()) {
            return -1;
        }
        if (student1.getNameStudent() != student2.getNameStudent()) {
            return student1.getNameStudent().compareTo(student2.getNameStudent());
        }
        return student1.getId() - student2.getId();
    }
}
