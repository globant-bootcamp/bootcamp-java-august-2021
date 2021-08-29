public class Triangulo extends Figura {

    public double base;
    public double altura;

    public Triangulo() {
    }

    public Triangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    public void calcularArea() {
        double area = (base * altura) / 2;
        this.area = area;
        System.out.println("Calculando el area del triangulo");
    }

    public String toString() {
        String estado = "Triangulo - color: " + color + ", " + "base: " + base + ", " + "altura: " + altura + ", "
                + "área: " + area;

        return estado;
    }

}
