package ChallengeDay3;

public class Triangle extends Figure {

    public double base;
    public double height;

    public Triangle() {
        super();
    }

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public void calculateArea() {
        this.area = (base * height) / 2;
        System.out.println("Calculating the area of the triangle.");
    }

    public String toString() {
        String state = "ChallengeDay3.Triangle - color: " + color + ", " + "base: " + base + ", " + "height: " + height + ", "
                + "area: " + area;

        return state;
    }

}
