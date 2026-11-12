package s20lab01;

import java.util.List;

// Lab01: nombres sin repetir y en orden alfabético -> distinct + sorted
// Fuente: lista.stream() | Intermedias: distinct, sorted | Terminal: toList()
public class S20Lab01AsistenciaMain {
    public static void main(String[] args) {
        List<String> registro1 = List.of("Sofia", "Ana", "Sofia", "Luis");
        List<String> registro2 = List.of("Ana", "Ana");
        List<String> registro3 = List.of();

        System.out.println("Caso 1: " + asistentes(registro1)); // [Ana, Luis, Sofia]
        System.out.println("Caso 2: " + asistentes(registro2)); // [Ana]
        System.out.println("Caso 3: " + asistentes(registro3)); // []

        // La fuente sigue con sus repetidos: no se borró nada de ella
        System.out.println("Original caso 1: " + registro1);

        // Dos nombres son repetidos cuando equals() da true:
        // mismo texto exacto, incluidas mayúsculas ("Ana" y "ana" serían distintos).
    }

    // Devuelve los nombres una sola vez y ordenados alfabéticamente
    public static List<String> asistentes(List<String> nombres) {
        return nombres.stream()
                .distinct() // quita los repetidos
                .sorted()   // orden natural de String = alfabético
                .toList();
    }
}
