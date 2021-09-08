package miniproject.bootcamp.np;

public class Player{
    public static final String INVALID_DATA = "ENTER DATA";
    public static final int INVALID_VALUE = 0;
    String[] playerLabels = new String[] { "ID: ", "NAME: ", "AGE: ", "STATUS: ", "TEAM: ", "POSITION: ", "RECORD: " };
    public int id;
    public String name;
    public int age;
    public String status;
    private String team;
    public String position;
    public int record;

    public Player(int id, String name, int age, String status, String team, String position, int record) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
        this.team = team;
        this.position = position;
        this.record = record;
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player() {
        this.id = INVALID_VALUE;
        this.name = INVALID_DATA;
        this.age = INVALID_VALUE;
        this.status = INVALID_DATA;
        this.team = INVALID_DATA;
        this.position = INVALID_DATA;
        this.record = INVALID_VALUE;
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
        System.out.println(playerLabels[0] + id);
        System.out.println(playerLabels[1] + name);
        System.out.println(playerLabels[2] + age);
        System.out.println(playerLabels[3] + status);
        System.out.println(playerLabels[4] + team);
        System.out.println(playerLabels[5] + position);
        System.out.println(playerLabels[6] + record);
    }
}