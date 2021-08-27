package band;

public class WoodwindQuartet {

    public static void main(String[] args) {
        Woodwind clarinet = new Woodwind("Clarinet");
        Woodwind flute = new Woodwind("Flute", "C");
        Woodwind oboe = new Woodwind("Oboe", "C");
        Woodwind bassoon = new Woodwind("Saxophone", "C");

        clarinet.play();
        oboe.play();
        bassoon.play();
        flute.play();

        clarinet.getTuning();
    }

}
