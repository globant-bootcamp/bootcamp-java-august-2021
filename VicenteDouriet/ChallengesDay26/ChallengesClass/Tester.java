public class Tester extends Employee {
    String work;

    @Override
    public void printData() {
        super.printData();
        System.out.println("Working in: "+ work);
    }

}
