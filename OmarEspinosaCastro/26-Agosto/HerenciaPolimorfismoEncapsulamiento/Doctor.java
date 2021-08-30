public class Doctor extends Job {

    public String specialty;

    public Doctor(String name, int age, double salary, String specialty) {
        super(name, age, salary);
        this.specialty = specialty;
    }
}
