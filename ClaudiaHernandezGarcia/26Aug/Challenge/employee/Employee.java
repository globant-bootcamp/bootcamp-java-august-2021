package employee;

public abstract class Employee {
    private String assignment;

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getAssignment() {
        return this.assignment;
    }

    public void displayAssignment() {
        System.out.println("Assigned to: " + this.getAssignment());
    }

    public abstract void doTheJob();
}
