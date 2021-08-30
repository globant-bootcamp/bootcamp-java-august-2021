package ChallengeDay3;

public class Rectangle extends Figure {

    public double base;
    public double height;

    public Rectangle() {
        super();
    }

    public Rectangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public void calculateArea() {
        this.area = base * height;
        System.out.println("Calculating the area of the ChallengeDay3.Rectangle");
    }

    public String toString() {
        String state = "ChallengeDay3.Rectangle - color: " + color + ", " + "base: " + base + ", " + "height: " + height + ", "
                + "area: " + area;

        return state;
    }
}
