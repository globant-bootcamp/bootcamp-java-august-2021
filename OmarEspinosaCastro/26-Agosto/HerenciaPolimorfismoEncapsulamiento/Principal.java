package herencia;
public class Principal {

    public static void main(String[] args) {
        String name = "Pablo";
        int age = 30;
        double salaryHour = 150;
        int huorsWorked = 20;
        String position = "Docente";
        Job docente = new Teacher(name, age, salaryHour, huorsWorked, position);
        salary(docente);
    }

    public static void salary(Job job) {
        if (job instanceof Driver) {
            ((Driver) job).calculateSalary();
            //System.out.println(job.getName() + " para el puesto de Chofer tu saldo es: " + job.getSalary());
            job.toString_();
        } else if (job instanceof Doctor) {
            //System.out.println(job.getName() + " para el puesto de Medico tu saldo es: " + job.getSalary());
            job.toString_();
        } else if (job instanceof Teacher) {
            ((Teacher) job).calculateSalary();
            //System.out.println(job.getName() + " para el puesto de docente tu saldo es: " + job.getSalary());
            job.toString_();
        }
    }
}
