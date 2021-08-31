package herencia;
public class Teacher extends Job {

    public double salaryHour;
    public int huorsWorked;

    public Teacher(String name, int age, double salaryHour, int huorsWorked, String position) {
        super(name, age, position);
        this.salaryHour = salaryHour;
        this.huorsWorked = huorsWorked;
    }

    public void calculateSalary() {
        super.setSalary(salaryHour * huorsWorked);
    }
}
