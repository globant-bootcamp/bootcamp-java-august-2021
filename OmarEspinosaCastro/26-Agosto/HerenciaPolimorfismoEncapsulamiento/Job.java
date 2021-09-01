package herencia;
public class Job {

    private String name;
    private int age;
    private double salary;
    private String position;
    
    public Job(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Job(String name, int age, double salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void toString_(){
        System.out.println(getName() + " para el puesto de "+getPosition()+" tu saldo es: " + getSalary());
    }

}
