public class Employee implements Printable {
    String name;
    int age;
    double salary;

    Employee() {

    }

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    @Override
    public void printInfo() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("salary: " + salary);
    }


}
