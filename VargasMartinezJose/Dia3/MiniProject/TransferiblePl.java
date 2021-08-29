public class TransferiblePl extends NewPlayer{

    public TransferiblePl(int id, String name, int age, String status, String team, String position, int record, int value, String newTeam, int injuries) {
        super(id, name, age, status, team, position, record);
        this.value=value;
        this.newTeam=newTeam;
        this.injuries=injuries;
      
    }
    
    public TransferiblePl(int id, String name ) {
        this.id=id;
        this.name=name;
      
    }
    public TransferiblePl(){
        this.id=0; 
        this.name="Enter data"; 
        this.age=0;
        this.status="Enter data";
        this.position="Enter data"; 
        this.record=0;
        this.value=0;
        this.newTeam="Enter data";
        this.injuries=0;

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
        System.out.println("value: "+value);
        System.out.println("newTeam: " + newTeam);
        System.out.println("injuries: " + injuries);
    }

    
}
