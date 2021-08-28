package band;

public class WoodwindQuartet {

    public static void main(String[] args) {
        Instrument lead = new Clarinet();
        Instrument supporting = new Saxophone();

        System.out.println("The lead instrument is a " + lead.getClass().getSimpleName());
        System.out.println("The supporting instrument is a " + supporting.getClass().getSimpleName());

        lead.getTuning();
        supporting.getTuning();

        lead.play();
        supporting.play();

    }

}
