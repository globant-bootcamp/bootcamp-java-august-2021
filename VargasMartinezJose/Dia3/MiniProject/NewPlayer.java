public class NewPlayer{
    
    public int id;
    public String name;
    public int age;
    public String status;
    private  String team;
    public String position;
    public  int record;


    public NewPlayer(int id, String name, int age, String status, String team, String position, int record) {
        this.id=id;
        this.name=name;
        this.age = age;
        this.status= status;
        this.team=team;
        this.position=position;
        this.record=record;

    }
    public NewPlayer(int id, String name) {
        this.id=id;
        this.name=name;
    }
    public NewPlayer(){
        this.id=0; 
        this.name="Enter data"; 
        this.age=0;
        this.status="Enter data";
        this.team="Enter data";
        this.position="Enter data"; 
        this.record=0;
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
    public void showData(String className){
        System.out.println(className);
        System.out.println("ID: " + id);
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("Status: " + status);
        System.out.println("team: " + team);
        System.out.println("position: " + position);
        System.out.println("record: " + record);
    }
}