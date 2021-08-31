package hackerrank.javasort;

class Student implements Comparable<Student> {
    private final Integer id;
    private final String fname;
    private final Double cgpa;

    public Student(Integer id, String fname, Double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public Integer getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public Double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student student) {
        int compareCgpa = cgpa.compareTo(student.getCgpa());

        if (!areEquals(compareCgpa)) {
            return invertOrder(compareCgpa);
        } else {
            int compareFname = fname.compareTo(student.getFname());

            if (!areEquals(compareFname)) {
                return compareFname;
            } else {
                return id.compareTo(student.getId());
            }

        }

    }

    private boolean areEquals(int resultOfCompare) {
        return resultOfCompare == 0;
    }

    private int invertOrder(int resultOfCompare) {
        return -resultOfCompare;
    }
}