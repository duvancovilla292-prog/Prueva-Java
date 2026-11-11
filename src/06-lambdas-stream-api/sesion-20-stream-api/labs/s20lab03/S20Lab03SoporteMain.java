package s20lab03;

import java.util.List;

// Lab03: total de minutos -> mapToInt + sum
// Fuente: lista.stream() | Intermedia: mapToInt | Terminal: sum()
public class S20Lab03SoporteMain {
    public static void main(String[] args) {
        List<Integer> minutos1 = List.of(12, 8, 20);
        List<Integer> minutos2 = List.of(8, 8);
        List<Integer> minutos3 = List.of();

        System.out.println("Caso 1: " + total(minutos1)); // 40
        System.out.println("Caso 2: " + total(minutos2)); // 16 (no se usa distinct, cada atención cuenta)
        System.out.println("Caso 3: " + total(minutos3)); // 0

        // sum() es la operación terminal que produce el número final.
        // Si no hay datos, sum() devuelve 0, así que no hace falta un if.
        // No se usa una variable externa ni forEach: el total sale del propio stream.
    }

    // Suma todos los minutos
    public static int total(List<Integer> minutos) {
        return minutos.stream()
                .mapToInt(Integer::intValue) // Integer -> int (IntStream), equivale a m -> m
                .sum();                      // suma todo; vacío = 0
    }
}
