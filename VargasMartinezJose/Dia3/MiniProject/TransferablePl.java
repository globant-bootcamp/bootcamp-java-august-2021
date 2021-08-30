public class TransferablePl extends NewPlayer {

    String[] strArray2 = new String[] { "VALUE: ", "NEW TEAM: ", "INJURIES: " };

    public TransferablePl(int id, String name, int age, String status, String team, String position, int record,
            int value, String newTeam, int injuries) {
        super(id, name, age, status, team, position, record);
        this.value = value;
        this.newTeam = newTeam;
        this.injuries = injuries;

    }

    public TransferablePl(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public TransferablePl() {

        this.id = NULL_INT;
        this.name = NULL_VALUE;
        this.age = NULL_INT;
        this.status = NULL_VALUE;
        this.position = NULL_VALUE;
        this.record = NULL_INT;
        this.value = NULL_INT;
        this.newTeam = NULL_VALUE;
        this.injuries = NULL_INT;

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
        System.out.println(strArray2[0] + value);
        System.out.println(strArray2[1] + newTeam);
        System.out.println(strArray2[2] + injuries);
    }

}
