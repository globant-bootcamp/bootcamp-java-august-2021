public class Rectangulo extends Figura {

    public double base;
    public double altura;

    public Rectangulo() {
    }

    public Rectangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    public void calcularArea() {
        double area = base * altura;
        this.area = area;
        System.out.println("Calculando el area del Rectangulo");
    }

    public String toString() {
        String estado = "Rectangulo - color: " + color + ", " + "base: " + base + ", " + "altura: " + altura + ", "
                + "área: " + area;

        return estado;
    }
}
