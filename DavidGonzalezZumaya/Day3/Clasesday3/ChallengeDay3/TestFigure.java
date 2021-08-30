public class TestFigure {
    public static void main(String[] args) {

        Figure[] figures = new Figure[3];
        final String COLOR = "Green";

        figures[0] = new Triangle(COLOR, 4.3, 8.6);
        figures[1] = new Circle(COLOR, 2.5);
        figures[2] = new Rectangle(COLOR, 15.2, 7.5);

        for (int index = 0; index < figures.length; index++) {

            if (figures[index] instanceof Circle) {
                System.out.println("The object of the index " + index + " is a circle.");
                Circle circle = (Circle) figures[index];
                circle.calculateDiameter();
            }

            figures[index].calculateArea();
            System.out.println(figures[index].toString());
            System.out.println("\n");
        }
    }
}
