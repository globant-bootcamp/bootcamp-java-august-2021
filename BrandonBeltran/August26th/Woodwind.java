package band;

public class Woodwind extends Instrument {
    private String family;

    public Woodwind(){
        super("Bb");
        family = "Clarinet";
    }

    public Woodwind(String family){
        super("Bb");
        this.family = family;
    }

    public Woodwind(String family, String tuning){
        super(tuning);
        this.family = family;
    }

    @Override
    void getTuning(){
        System.out.printf("The %s ", family);
        super.getTuning();
    }

    @Override
    void play(){
        System.out.printf("The %s plays... Do do do do...%n", family);
    }
}
