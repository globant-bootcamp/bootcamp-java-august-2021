public class Rectangle extends Figure {

    public double base;
    public double height;

    public Rectangle() {
    }

    public Rectangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public void calculateArea() {
        double area = base * height;
        this.area = area;
        System.out.println("Calculating the area of the Rectangle");
    }

    public String toString() {
        String state = "Rectangle - color: " + color + ", " + "base: " + base + ", " + "height: " + height + ", "
                + "area: " + area;

        return state;
    }
}
