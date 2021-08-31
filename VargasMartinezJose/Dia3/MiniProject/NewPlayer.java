package miniproject.bootcamp.np;

public class NewPlayer {

    public static final String NULL_VALUE = "ENTER DATA";
    public static final int NULL_INT = 0;
    String[] strArray = new String[] { "ID: ", "NAME: ", "AGE: ", "STATUS: ", "TEAM: ", "POSITION: ", "RECORD: " };
    public int id;
    public String name;
    public int age;
    public String status;
    private String team;
    public String position;
    public int record;

    public NewPlayer(int id, String name, int age, String status, String team, String position, int record) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
        this.team = team;
        this.position = position;
        this.record = record;

    }

    public NewPlayer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public NewPlayer() {
        this.id = NULL_INT;
        this.name = NULL_VALUE;
        this.age = NULL_INT;
        this.status = NULL_VALUE;
        this.team = NULL_VALUE;
        this.position = NULL_VALUE;
        this.record = NULL_INT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public void showData(String className) {
        System.out.println(className);
        System.out.println(strArray[0] + id);
        System.out.println(strArray[1] + name);
        System.out.println(strArray[2] + age);
        System.out.println(strArray[3] + status);
        System.out.println(strArray[4] + team);
        System.out.println(strArray[5] + position);
        System.out.println(strArray[6] + record);
    }
}