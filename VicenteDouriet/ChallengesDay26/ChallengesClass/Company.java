public class Company {
    public static void main(String[] args){

        Employee e1 = new Employee("Vicente", 29, 9999999);
        Employee e = new Employee();
        e.name = "Emily";
        e.age = 45;
        e.salary = 65520.00;

        Developer p = new Developer();
        p.name = "Ben";
        p.age = 37;
        p.salary = 77435.00;
        p.work = "Developing";

        Tester d = new Tester();
        d.name = "Jack";
        d.age = 28;
        d.salary = 45000.00;
        d.work = "Testing";

        e.printData();
        p.printData();
        d.printData();
        e1.printData();
    }
}
