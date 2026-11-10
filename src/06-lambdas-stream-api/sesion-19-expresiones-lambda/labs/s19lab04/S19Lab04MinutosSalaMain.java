package s19lab04;

import java.util.function.BiFunction;

// Lab04: recibe dos datos (contratados, utilizados) y devuelve un Integer
// -> BiFunction<Integer, Integer, Integer>. Se ejecuta con apply(contratados, utilizados)
public class S19Lab04MinutosSalaMain {
    public static void main(String[] args) {
        // Regla: restantes = contratados - utilizados
        BiFunction<Integer, Integer, Integer> calcularRestantes =
                (contratados, utilizados) -> contratados - utilizados;

        // Casos de prueba
        System.out.println("120 - 45 = " + calcularRestantes.apply(120, 45));
        System.out.println("120 - 0 = " + calcularRestantes.apply(120, 0));
        System.out.println("120 - 120 = " + calcularRestantes.apply(120, 120));

        // Necesita dos argumentos porque el resultado depende de dos datos distintos.
        // El método que la ejecuta es apply(primero, segundo).
    }
}
