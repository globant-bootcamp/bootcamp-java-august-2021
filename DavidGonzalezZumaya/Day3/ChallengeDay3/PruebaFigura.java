public class PruebaFigura {
    public static void main(String[] args) {

        Figura[] figuras = new Figura[3]; // arreglo de referencias a figuras

        figuras[0] = new Triangulo("morado", 4.3, 8.6);
        figuras[1] = new Circulo("turquesa", 2.5);
        figuras[2] = new Rectangulo("rosa", 15.2, 7.5);

        for (int i = 0; i < 3; i++) {
            if (figuras[i] instanceof Circulo) {
                System.out.println("El objeto del indice " + i + " es un circulo.");
                Circulo c = (Circulo) figuras[i];
                c.calcularDiametro();
            }
            figuras[i].calcularArea();

            System.out.println(figuras[i].toString());
            System.out.println("\n");
        }
    }
}
