package bootcamp;

class Student implements Comparable<Student>{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
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
    public int compareTo(Student versus) {
        Double externalCgpa = versus.getCgpa();
        int comparison = externalCgpa.compareTo(this.getCgpa());

        if(comparison == 0){
            comparison = this.fname.compareTo(versus.getFname());
        }

        return comparison;
    }
}