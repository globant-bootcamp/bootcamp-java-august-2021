package band;

public class Saxophone extends Woodwind {
    private String type;

    public Saxophone(){
        super("Saxophone", "Eb");
        type = "Alto";
    }

    public Saxophone(String tuning){
        super("Saxophone", tuning);
    }

    public Saxophone(String type, String tuning){
        super("Saxophone", tuning);
        this.type = type;
    }
}
