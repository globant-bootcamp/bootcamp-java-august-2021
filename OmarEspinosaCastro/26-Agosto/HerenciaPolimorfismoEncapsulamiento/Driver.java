public class Driver extends Job {
    public double salaryTravel;
    public int numberTravel;
    public Driver(String name, int age, double salaryTravel, int numberTravel){
        super(name,age);
        this.salaryTravel = salaryTravel;
        this.numberTravel = numberTravel;
    }
    public void calculateSalary(){
        super.setSalary(salaryTravel*numberTravel);
    }
}
