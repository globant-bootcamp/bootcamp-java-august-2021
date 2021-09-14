package miniproject.bootcamp.tf;

public class TransferablePlayer extends Player {
    String[] transferableLabels = new String[] { "VALUE: ", "NEW TEAM: ", "INJURIES: " };
    public TransferablePlayer(int id, String name, int age, String status, String team, String position, int record,
            int value, String newTeam, int injuries) {
        super(id, name, age, status, team, position, record);
        this.value = value;
        this.newTeam = newTeam;
        this.injuries = injuries;
    }
    public TransferablePlayer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public TransferablePlayer() {
        this.id = INVALID_VALUE;
        this.name =INVALID_DATA;
        this.age = INVALID_VALUE;
        this.status = INVALID_DATA;
        this.position =INVALID_DATA;
        this.record = INVALID_VALUE;
        this.value = INVALID_VALUE;
        this.newTeam = INVALID_DATA;
        this.injuries = INVALID_VALUE;
    }
    private int value;
    private String newTeam;
    private int injuries;

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getNewTeam() {
        return newTeam;
    }
    public void setNewTeam(String newTeam) {
        this.newTeam = newTeam;
    }
     public int getInjuries() {
        return injuries;
    }
    public void setInjuries(int injuries) {
        this.injuries = injuries;
    }
    @Override
    public void showData(String className) {
        super.showData(className);
        System.out.println(transferableLabels[0] + value);
        System.out.println(transferableLabels[1] + newTeam);
        System.out.println(transferableLabels[2] + injuries);
    }
}
