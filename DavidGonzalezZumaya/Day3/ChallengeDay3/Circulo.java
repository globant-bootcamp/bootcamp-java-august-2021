public class Circulo extends Figura {

    public static final double PI = 3.1416;

    public double radio;

    public Circulo() {
    }

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    public void calcularArea() {
        double area = PI * Math.pow(radio, 2);
        this.area = area;
        System.out.println("calculando area del circulo");
    }

    public void calcularDiametro() {
        double diametro = radio * 2;
        System.out.println("calculando diametro del circulo");
        System.out.println(diametro);
    }

    public String toString() {
        String estado = "Circulo - color: " + color + ", " + "radio: " + radio + ", " + "área: " + area;

        return estado;
    }
}
