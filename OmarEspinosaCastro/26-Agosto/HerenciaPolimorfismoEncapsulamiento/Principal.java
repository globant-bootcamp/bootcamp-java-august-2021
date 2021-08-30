
public class Principal {

    public static void main(String[] args) {

        Job[] jobs = new Job[3];
        jobs[0] = new Driver("Juan", 30, 1000.0, 5);
        jobs[1] = new Doctor("Pedro", 55, 20000, "Cirujano");
        jobs[2] = new Teacher("Pablo", 30, 150, 20);

        for (Job job : jobs) {
            salary(job);
        }

    }

    public static void salary(Job job) {
        if (job instanceof Driver) {
            ((Driver) job).calculateSalary();
            System.out.println(job.getName() + " para el puesto de Chofer tu saldo es: " + job.getSalary());
        } else if (job instanceof Doctor) {
            System.out.println(job.getName() + " para el puesto de Medico tu saldo es: " + job.getSalary());
        } else if (job instanceof Teacher) {
            ((Teacher) job).calculateSalary();
            System.out.println(job.getName() + " para el puesto de docente tu saldo es: " + job.getSalary());
        }
    }
}
