package herencia;
public class Doctor extends Job {

    public String specialty;

    public Doctor(String name, int age, double salary, String specialty, String position) {
        super(name, age, salary, position);
        this.specialty = specialty;
    }
}
