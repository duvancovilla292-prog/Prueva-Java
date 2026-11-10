package s19lab03;

import java.util.function.Function;

// Lab03: recibe gramos (Integer) y devuelve kilogramos (Double) -> Function<Integer, Double>
// Se ejecuta con apply(gramos)
public class S19Lab03PesoPaqueteMain {
    public static void main(String[] args) {
        // Transformación: se divide entre 1000.0 para no perder los decimales
        Function<Integer, Double> aKilogramos = gramos -> gramos / 1000.0;

        // Pesos de prueba
        int[] pesos = {500, 1000, 2500};
        for (int gramos : pesos) {
            // apply() devuelve el resultado; se guarda y luego se muestra
            double kilos = aKilogramos.apply(gramos);
            System.out.println(gramos + " g = " + kilos + " kg");
        }

        // Se devuelve (no se imprime adentro) para poder usar el valor
        // en otro cálculo después, por ejemplo una tarifa.
    }
}
