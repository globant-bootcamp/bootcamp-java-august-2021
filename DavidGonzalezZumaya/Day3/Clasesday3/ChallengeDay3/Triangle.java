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
        double area = (base * height) / 2;
        this.area = area;
        System.out.println("Calculating the area of the triangle.");
    }

    public String toString() {
        String state = "Triangle - color: " + color + ", " + "base: " + base + ", " + "height: " + height + ", "
                + "area: " + area;

        return state;
    }

}
