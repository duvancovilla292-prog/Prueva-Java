package s20lab05;

import java.util.List;

// Lab05: dos preguntas distintas -> filter + count (long) y anyMatch (boolean)
// Cada pregunta usa un stream NUEVO, porque un stream se consume una sola vez
public class S20Lab05RutasMain {
    public static void main(String[] args) {
        mostrar(List.of(18, 25, 12, 30)); // 2 | false
        mostrar(List.of(20, 36));         // 1 | true
        mostrar(List.of());               // 0 | false
    }

    // Imprime las dos respuestas para un caso
    public static void mostrar(List<Integer> duraciones) {
        System.out.println(duraciones + " -> superan 20: " + cuantosSuperan20(duraciones)
                + " | alguno supera 35: " + algunoSupera35(duraciones));
    }

    // ¿Cuántos superan 20? -> número (long)
    public static long cuantosSuperan20(List<Integer> duraciones) {
        return duraciones.stream()          // stream nuevo
                .filter(minutos -> minutos > 20) // > y no >=: 20 NO supera 20
                .count();                   // cuenta los que pasaron
    }

    // ¿Existe alguno que supere 35? -> sí/no (boolean)
    public static boolean algunoSupera35(List<Integer> duraciones) {
        return duraciones.stream()          // otro stream nuevo desde la misma lista
                .anyMatch(minutos -> minutos > 35); // true si al menos uno cumple; vacío = false
    }
}
