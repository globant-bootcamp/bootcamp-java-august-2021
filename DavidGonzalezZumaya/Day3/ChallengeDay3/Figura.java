public abstract class Figura {
    public String color;
    public double area;

    public Figura() {
    }

    public Figura(String color) {
        this.color = color;
    }

    public abstract void calcularArea();

}