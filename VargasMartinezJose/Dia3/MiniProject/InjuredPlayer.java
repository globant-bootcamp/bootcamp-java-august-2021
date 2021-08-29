public class InjuredPlayer extends NewPlayer{

    public InjuredPlayer(int id, String name, int age, String status, String team, String position, int record, int time) {
        super(id, name, age, status, team, position, record);
        this.time=time;
    }

    public InjuredPlayer(){

    }
    public  InjuredPlayer(int id, String name){
        
    }    
    private int time;
    
    
    public int getTime() {
        return time;
    }


    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public void showData(String className) {
        super.showData(className);
        System.out.println("time: " + time);
    }
    
    
}
