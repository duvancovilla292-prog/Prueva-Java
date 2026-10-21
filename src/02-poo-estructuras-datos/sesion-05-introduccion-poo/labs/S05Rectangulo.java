public class S05Rectangulo {
    /*// TODO 1: Declarar base y altura como campos privados double.

    public S05Rectangulo(double base, double altura) {
        // TODO 2: Guardar los dos parametros en los campos usando this.
    }

    public double calcularArea() {
        // TODO 3: Devolver el area calculada con base y altura.
        return 0.0; // Retorno provisional: reemplazar.
    }

    public double calcularPerimetro() {
        // TODO 4: Devolver el perimetro calculado con base y altura.
        return 0.0; // Retorno provisional: reemplazar.
    }

    public boolean esCuadrado() {
        // TODO 5: Devolver si base y altura son iguales.
        return false; // Retorno provisional: reemplazar.
    }*/
    private double base;
    private double altura;

    public S05Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public boolean esCuadrado() {
        return base == altura;
    }
}
