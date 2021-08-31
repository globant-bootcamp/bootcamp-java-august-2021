package herencia;
public class Driver extends Job {
    public double salaryTravel;
    public int numberTravel;
    public Driver(String name, int age, double salaryTravel, int numberTravel, String position){
        super(name, age, position);
        this.salaryTravel = salaryTravel;
        this.numberTravel = numberTravel;
    }
    public void calculateSalary(){
        super.setSalary(salaryTravel*numberTravel);
    }
}
