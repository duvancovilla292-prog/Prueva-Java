package s20lab02;

import java.util.List;

// Lab02: convertir cada peso de kg a gramos -> map
// Fuente: lista.stream() | Intermedia: map | Terminal: toList()
public class S20Lab02PesosMain {
    public static void main(String[] args) {
        // Elegí lista (List) como fuente
        List<Integer> kilos1 = List.of(5, 12, 8);
        List<Integer> kilos2 = List.of(0, 2);
        List<Integer> kilos3 = List.of();

        System.out.println("Caso 1: " + aGramos(kilos1)); // [5000, 12000, 8000]
        System.out.println("Caso 2: " + aGramos(kilos2)); // [0, 2000] -> 0 * 1000 = 0
        System.out.println("Caso 3: " + aGramos(kilos3)); // []

        System.out.println("Original caso 1: " + kilos1);

        // Entra un Integer (kilos) y sale otro Integer (gramos).
        // map transforma 1 a 1: misma cantidad de elementos y mismo orden.
    }

    // Multiplica cada peso por 1000
    public static List<Integer> aGramos(List<Integer> kilos) {
        return kilos.stream()
                .map(kg -> kg * 1000) // transforma cada elemento
                .toList();
    }
}
