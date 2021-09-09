package bootcamp;

class Student implements Comparable<Student>{
    private int id;
    private String firstName;
    private double culmulativeGradePointAverage;
    public Student(int id, String firstName, double culmulativeGradePointAverage) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.culmulativeGradePointAverage = culmulativeGradePointAverage;
    }
    public int getId() {
        return id;
    }
    public String getFistName() {
        return firstName;
    }
    public double getCulmulativeGradePointAverage() {
        return culmulativeGradePointAverage;
    }

    @Override
    public int compareTo(Student versus) {
        Double externalCulmulativeGradePointAverage = versus.getCulmulativeGradePointAverage();
        int comparison = externalCulmulativeGradePointAverage.compareTo(this.getCulmulativeGradePointAverage());

        if(comparison == 0){
            comparison = this.firstName.compareTo(versus.getFistName());
        }

        return comparison;
    }
}