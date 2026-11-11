package s20lab00;

import java.util.List;

// Lab00: seleccionar notas aprobadas (70 o más) -> filter
// Fuente: lista.stream() | Intermedia: filter | Terminal: toList()
public class S20Lab00NotasAprobadasMain {
    public static void main(String[] args) {
        // Datos de los tres casos (List.of crea listas que no se pueden modificar)
        List<Integer> notas1 = List.of(50, 70, 90, 65);
        List<Integer> notas2 = List.of(40, 60);
        List<Integer> notas3 = List.of();

        System.out.println("Caso 1: " + aprobadas(notas1)); // [70, 90]
        System.out.println("Caso 2: " + aprobadas(notas2)); // []
        System.out.println("Caso 3: " + aprobadas(notas3)); // []

        // La lista original no cambia: el stream solo la recorre
        System.out.println("Original caso 1: " + notas1);

        // Límite inclusivo: se usa >= y no >, por eso el 70 SÍ se conserva.
        // filter mantiene el orden de registro: 70 aparece antes que 90.
    }

    // Devuelve una lista nueva solo con las notas >= 70
    public static List<Integer> aprobadas(List<Integer> notas) {
        return notas.stream()
                .filter(nota -> nota >= 70) // deja pasar solo las que cumplen
                .toList();                  // junta el resultado en una lista
    }
}
