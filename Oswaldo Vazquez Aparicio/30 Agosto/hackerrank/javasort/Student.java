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

        if (compareCgpa != 0) {
            return -compareCgpa;
        } else {
            int compareFname = fname.compareTo(student.getFname());

            if (compareFname != 0) {
                return compareFname;
            } else {
                return id.compareTo(student.getId());
            }

        }

    }

}