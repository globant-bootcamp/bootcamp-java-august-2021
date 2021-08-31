package employee;

public class Tester extends Employee {
    private String framework;

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getFramework() {
        return this.framework;
    }

    public void displayFramework() {
        System.out.println("Seniority: " + this.getFramework());
    }

    @Override
    public void doTheJob() {
        System.out.println("Testing in process...");
    }
}
