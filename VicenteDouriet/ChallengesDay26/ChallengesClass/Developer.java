public class Developer extends Employee {
    String work;

    @Override
    public void printInfo() {
        System.out.println("Working in: " + work);
    }
}
