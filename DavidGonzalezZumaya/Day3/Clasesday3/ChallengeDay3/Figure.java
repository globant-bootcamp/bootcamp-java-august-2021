package ChallengeDay3;

public abstract class Figure {

    public String color;
    public double area;

    public Figure() {
    }

    public Figure(String color) {
        this.color = color;
    }

    public abstract void calculateArea();

}