public class Circle extends Figure {

    public static final double PI = 3.1416;

    public double radius;

    public Circle() {
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public void calculateArea() {
        double area = PI * Math.pow(radius, 2);
        this.area = area;
        System.out.println("calculating area of circle");
    }

    public void calculateDiameter() {
        double diameter = radius * 2;
        System.out.println("calculating circle diameter");
        System.out.println(diameter);
    }

    public String toString() {
        String estate = "Circle - color: " + color + ", " + "radius: " + radius + ", " + "area: " + area;

        return estate;
    }
}
