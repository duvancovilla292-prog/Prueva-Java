package s20demo01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * DEMO 01: Fuentes de un Stream y operaciones terminales
 * ------------------------------------------------------
 * Un Stream puede crearse desde distintas FUENTES:
 *   1) Una coleccion (List, Set...)  -> lista.stream()
 *   2) Un arreglo (array)            -> Arrays.stream(arreglo)
 *   3) Valores sueltos               -> Stream.of(v1, v2, v3)
 * Sin importar la fuente, despues se usan las mismas operaciones (filter, toList...).
 *
 * Tambien se muestran otras operaciones TERMINALES ademas de toList():
 *   count()    -> cuenta cuantos elementos llegaron al final (devuelve long).
 *   anyMatch() -> responde si AL MENOS UNO cumple una condicion (devuelve boolean).
 *
 * Regla importante: un stream se consume UNA sola vez. Para hacer otra
 * "pregunta" sobre los mismos datos, se crea un stream nuevo desde la fuente.
 */
public class S20Demo01FuentesMain {

    // main: punto de entrada del programa.
    public static void main(String[] args) {
        // Fuente 1: lista inmutable de nombres.
        List<String> lista = List.of("Ana", "Luis", "Luz", "Pablo");
        // Fuente 2: arreglo de String (tamano fijo) con los mismos nombres.
        String[] arreglo = {"Ana", "Luis", "Luz", "Pablo"};

        // ---------- 1. Desde una LISTA ----------
        // lista.stream(): toda coleccion tiene el metodo stream().
        // startsWith("L"): metodo de String; true si el texto empieza con "L".
        //   Ejemplo: "Luis".startsWith("L") -> true ; "Ana".startsWith("L") -> false
        List<String> desdeLista = lista.stream()
                .filter(nombre -> nombre.startsWith("L"))
                .toList();

        // ---------- 2. Desde un ARREGLO ----------
        // Los arreglos NO tienen metodo stream(); se usa la clase utilitaria
        // Arrays y su metodo estatico Arrays.stream(arreglo).
        List<String> desdeArreglo = Arrays.stream(arreglo)
                .filter(nombre -> nombre.startsWith("L"))
                .toList();

        // ---------- 3. Desde VALORES sueltos ----------
        // Stream.of(...): crea un stream directamente con los valores dados,
        // sin necesidad de tener una lista o arreglo antes.
        List<String> desdeValores = Stream.of("Ana", "Luis", "Luz", "Pablo")
                .filter(nombre -> nombre.startsWith("L"))
                .toList();

        // Las tres formas dan el mismo resultado: [Luis, Luz]
        System.out.println("1. Lista: " + desdeLista);
        System.out.println("2. Arreglo: " + desdeArreglo);
        System.out.println("3. Valores: " + desdeValores);

        // Cada pregunta inicia un stream nuevo desde la misma fuente.
        // count(): operacion terminal; devuelve la cantidad de elementos como long
        // (long = entero de mayor capacidad que int).
        // Ejemplo: ["Luis", "Luz"] -> 2
        long cantidad = lista.stream()
                .filter(nombre -> nombre.startsWith("L"))
                .count();

        // anyMatch(Predicate): operacion terminal; devuelve true si ALGUN elemento
        // cumple la condicion. Se detiene apenas encuentra uno (cortocircuito).
        // Si ninguno cumple (o la fuente esta vacia) devuelve false.
        // Metodos parecidos: allMatch() (todos cumplen) y noneMatch() (ninguno cumple).
        boolean existeZ = lista.stream()
                .anyMatch(nombre -> nombre.startsWith("Z"));
        System.out.println("Cantidad con L: " + cantidad);        // 2
        System.out.println("Existe nombre con Z: " + existeZ);    // false

        // Las fuentes originales NO cambiaron.
        System.out.println("Lista original: " + lista);
        // Arrays.toString(arreglo): convierte el arreglo a texto legible, ej: [Ana, Luis, Luz, Pablo].
        // (Si imprimieras el arreglo directo saldria algo como "[Ljava.lang.String;@1b6d3586").
        System.out.println("Arreglo original: " + Arrays.toString(arreglo));
    }
}
