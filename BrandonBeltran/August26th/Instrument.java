package band;

public class Instrument {
    private String tuning;

    public Instrument(){
        this.tuning = "C";
    }

    public Instrument(String tuning){
        this.tuning = tuning;
    }

    void getTuning(){
        System.out.printf( "is in the tone of %s%n", tuning);
    }

    void play(){
        System.out.printf("The instrument plays... Do do do do...%n");
    }
}
