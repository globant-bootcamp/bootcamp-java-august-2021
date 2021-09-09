package javaSort;

import java.util.Comparator;

class SortInDescendingOrder implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getCgpa() == student2.getCgpa()) {
            if (student1.getFname() == student2.getFname()) {
                return student2.getId() - student1.getId();
            }

            return student1.getFname().compareTo(student2.getFname());
        }
        return student2.getCgpa() > student1.getCgpa() ? 1 : -1;
    }
}
