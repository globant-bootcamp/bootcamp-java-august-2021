public class Employee {
    String name;
    int age;
    double salary;

    Employee(){

    }
    Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }



    public void printData(){
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("salary: " + salary);
    }



}
