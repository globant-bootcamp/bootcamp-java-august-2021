package band;

public class Clarinet extends Woodwind {
    private String type;

    public Clarinet(){
        super();
        type = "Classic";
    }

    public Clarinet(String tuning){
        super("Clarinet", tuning);
    }

    public Clarinet(String type, String tuning){
        super("Clarinet", tuning);
        this.type = type;
    }
}
