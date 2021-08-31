package employee;

public class Programmer extends Employee {
    private String seniority;

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getSeniority() {
        return this.seniority;
    }

    public void displaySeniority() {
        System.out.println("Seniority: " + this.getSeniority());
    }

    @Override
    public void doTheJob() {
        System.out.println("Programing in process...");
    }
}
