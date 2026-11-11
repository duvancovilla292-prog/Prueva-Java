package s20demo00;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * DEMO 00: Primer Stream (ciclo for vs. Stream API)
 * -------------------------------------------------
 * Un STREAM es una "tuberia" (pipeline) por donde pasan los elementos de una
 * fuente (por ejemplo una lista) para procesarlos paso a paso.
 * NO guarda datos y NO modifica la fuente original: solo la recorre.
 *
 * Un pipeline tiene 3 partes:
 *   1) FUENTE                 -> de donde salen los datos.        Ej: lista.stream()
 *   2) OPERACIONES INTERMEDIAS -> transforman/filtran y devuelven otro Stream. Ej: filter(...)
 *   3) OPERACION TERMINAL     -> produce el resultado final y "cierra" el stream. Ej: toList()
 *
 * Las operaciones intermedias son PEREZOSAS (lazy): no se ejecutan hasta que
 * se llama a una operacion terminal.
 *
 * Ejemplo:
 *   List.of(1, 2, 3, 4).stream().filter(n -> n % 2 == 0).toList(); // [2, 4]
 */
public class S20Demo00PrimerStreamMain {

    // main: punto de entrada del programa. Java empieza a ejecutar aqui.
    public static void main(String[] args) {
        // List.of(...): crea una lista INMUTABLE (no se puede agregar ni quitar elementos).
        // List<Integer>: lista de numeros enteros. Se usa Integer (clase) y no int,
        // porque las colecciones solo guardan objetos.
        List<Integer> temperaturas = List.of(24, 30, 35, 28);

        // ---------- FORMA 1: con ciclo (estilo imperativo: decimos COMO hacerlo) ----------
        // ArrayList: lista modificable donde iremos guardando las temperaturas altas.
        List<Integer> conCiclo = new ArrayList<>();
        // for-each: en cada vuelta "temperatura" toma el siguiente valor de la lista.
        for (int temperatura : temperaturas) {
            if (temperatura >= 30) {
                conCiclo.add(temperatura); // add(): agrega al final de la lista
            }
        }
        System.out.println("Antes Con ciclo: " + conCiclo); // [30, 35]

        // ---------- FORMA 2: con Stream (estilo declarativo: decimos QUE queremos) ----------
        // stream(): convierte la lista en un Stream (la FUENTE del pipeline).
        // filter(Predicate): operacion INTERMEDIA. Deja pasar solo los elementos
        //   para los que la lambda devuelve true. Devuelve un nuevo Stream.
        //   Ejemplo: 35 -> 35 >= 30 -> true (pasa); 24 -> false (se descarta).
        // Stream<Integer>: tipo del stream; "una tuberia de Integer".
        Stream<Integer> seleccion = temperaturas.stream()
                .filter(temperatura -> temperatura >= 30);
        // Hasta aqui NO se ha filtrado nada todavia (evaluacion perezosa):
        // solo se "describio" el pipeline.
        System.out.println("Pipeline definido; falta obtener el resultado.");

        // toList(): operacion TERMINAL. Ejecuta el pipeline y junta los elementos
        // que llegaron al final en una nueva lista (inmutable).
        // Ojo: un stream solo se puede consumir UNA vez; si volvieras a usar
        // "seleccion" despues de esto, lanzaria IllegalStateException.
        List<Integer> conStream = seleccion.toList();
        System.out.println("Ahora Con stream: " + conStream); // [30, 35]

        // La lista original NO cambio: los streams no modifican la fuente.
        System.out.println("Original: " + temperaturas);       // [24, 30, 35, 28]

        // Casos borde:
        // Ninguna temperatura cumple -> lista vacia [].
        System.out.println("Sin coincidencias: " + seleccionar(List.of(20, 25)));
        // Fuente vacia: List.of() sin elementos -> tambien devuelve [] (no hay error).
        System.out.println("Fuente vacia: " + seleccionar(List.of()));
    }

    /*
     * seleccionar(List<Integer> temperaturas)
     * static -> se puede llamar sin crear un objeto de la clase.
     * Devuelve una NUEVA lista solo con las temperaturas >= 30.
     * Es el mismo pipeline de arriba, pero escrito "de corrido" en un metodo
     * reutilizable: fuente -> filter -> toList.
     *
     * Ejemplo:
     *   seleccionar(List.of(31, 10, 40)) -> [31, 40]
     *   seleccionar(List.of(20, 25))     -> []
     */
    public static List<Integer> seleccionar(List<Integer> temperaturas) {
        return temperaturas.stream()
                .filter(temperatura -> temperatura >= 30)
                .toList();
    }
}
