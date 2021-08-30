public class Company {
    public static void main(String[] args) {

        Employee vicenteEmp = new Employee("Vicente", 29, 9999999);
        Employee emilyEmp = new Employee();
        emilyEmp.name = "Emily";
        emilyEmp.age = 45;
        emilyEmp.salary = 65520.00;

        Developer benDev = new Developer();
        benDev.name = "Ben";
        benDev.age = 37;
        benDev.salary = 77435.00;
        benDev.work = "Developing";

        Tester jackTes = new Tester();
        jackTes.name = "Jack";
        jackTes.age = 28;
        jackTes.salary = 45000.00;
        jackTes.work = "Testing";

        emilyEmp.printInfo();
        benDev.printInfo();
        jackTes.printInfo();
        vicenteEmp.printInfo();
    }
}
