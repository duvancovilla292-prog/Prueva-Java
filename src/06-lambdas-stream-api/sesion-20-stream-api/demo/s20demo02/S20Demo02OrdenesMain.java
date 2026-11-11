package s20demo02;

import java.util.List;

/*
 * DEMO 02: map vs flatMap, distinct, sorted, mapToInt, sum y reduce
 * -----------------------------------------------------------------
 * map(Function)      -> transforma CADA elemento en otro (1 entra, 1 sale).
 *                       Ejemplo: Stream.of("a", "bb").map(String::length) -> 1, 2
 * flatMap(Function)  -> transforma cada elemento en un STREAM y luego "aplana"
 *                       todos esos streams en uno solo (1 entra, 0..N salen).
 *                       Ejemplo: [[1, 2], [3]] -> 1, 2, 3
 * distinct()         -> quita los elementos repetidos (usa equals()).
 * sorted()           -> ordena los elementos en su orden natural
 *                       (numeros de menor a mayor, textos alfabeticamente).
 * mapToInt(...)      -> convierte a un IntStream (stream de int primitivos),
 *                       que tiene metodos numericos como sum(), average(), max().
 * reduce(inicial, op)-> combina todos los elementos en UN solo valor,
 *                       aplicando la operacion de dos en dos.
 *
 * REFERENCIA A METODO (Clase::metodo): forma abreviada de una lambda que solo
 * llama a un metodo. Ejemplo: Item::getNombre equivale a item -> item.getNombre()
 */
public class S20Demo02OrdenesMain {

    // main: punto de entrada del programa.
    public static void main(String[] args) {
        // Lista de ordenes; cada orden tiene su propia lista de items (datos anidados).
        // O3 no tiene items: sirve para ver que flatMap la maneja sin problema.
        List<Orden> ordenes = List.of(
                new Orden("O1", List.of(new Item("Cuaderno", 2), new Item("Lapiz", 3))),
                new Orden("O2", List.of(new Item("Cuaderno", 1), new Item("Borrador", 4))),
                new Orden("O3", List.of()));

        // ---------- 1. map: cada Orden -> su List<Item> ----------
        // El resultado es una LISTA DE LISTAS (List<List<Item>>): sigue anidado.
        List<List<Item>> anidados = ordenes.stream()
                .map(Orden::getItems) // map(orden -> orden.getItems())
                .toList();
        System.out.println("1. Listas internas: " + anidados);
        // [[Cuaderno:2, Lapiz:3], [Cuaderno:1, Borrador:4], []]

        // ---------- 2. flatMap: cada Orden -> Stream<Item>, y todo se une en uno ----------
        // orden.getItems().stream(): convierte la lista interna en un stream.
        // flatMap junta todos esos streams en un unico Stream<Item> (lista "plana").
        // La orden vacia (O3) aporta un stream vacio, asi que no agrega nada.
        List<Item> planos = ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .toList();
        System.out.println("2. Items planos: " + planos);
        // [Cuaderno:2, Lapiz:3, Cuaderno:1, Borrador:4]

        System.out.println("3. Nombres unicos ordenados: " + nombresUnicos(ordenes)); // [Borrador, Cuaderno, Lapiz]
        System.out.println("4. Unidades con sum: " + totalConSum(ordenes));            // 10
        System.out.println("5. Unidades con reduce: " + totalConReduce(ordenes));      // 10
        // Las ordenes originales no cambiaron.
        System.out.println("Original: " + ordenes.stream().map(Orden::getItems).toList());

        // Casos borde: ordenes sin ningun item.
        List<Orden> sinItems = List.of(new Orden("Vacia", List.of()));
        System.out.println("Todas vacias: " + nombresUnicos(sinItems));   // []
        System.out.println("Suma vacia: " + totalConSum(sinItems));       // 0 (sum de nada es 0)
        System.out.println("Reduccion vacia: " + totalConReduce(sinItems)); // 0 (devuelve el valor inicial)
    }

    /*
     * nombresUnicos(List<Orden> ordenes)
     * Devuelve los nombres de todos los items, SIN repetidos y ordenados.
     * Pasos del pipeline:
     *   flatMap  -> Stream<Item> con todos los items de todas las ordenes
     *   map      -> Stream<String> con solo los nombres (Item::getNombre)
     *   distinct -> quita repetidos ("Cuaderno" aparece 2 veces -> queda 1)
     *   sorted   -> orden alfabetico
     *   toList   -> junta en una lista
     *
     * Ejemplo con el demo: [Borrador, Cuaderno, Lapiz]
     */
    public static List<String> nombresUnicos(List<Orden> ordenes) {
        return ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .map(Item::getNombre)
                .distinct()
                .sorted()
                .toList();
    }

    /*
     * totalConSum(List<Orden> ordenes)
     * Suma las unidades de todos los items de todas las ordenes.
     *   mapToInt(Item::getUnidades) -> IntStream con las unidades (2, 3, 1, 4)
     *   sum()                       -> operacion terminal: suma todo -> 10
     * Si no hay elementos, sum() devuelve 0.
     */
    public static int totalConSum(List<Orden> ordenes) {
        return ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .mapToInt(Item::getUnidades)
                .sum();
    }

    /*
     * totalConReduce(List<Orden> ordenes)
     * Mismo resultado que totalConSum, pero usando reduce para ver "por dentro"
     * como se acumula el valor.
     *   reduce(0, Integer::sum):
     *     0            -> valor inicial (identidad); es lo que se devuelve si no hay elementos.
     *     Integer::sum -> metodo estatico que suma dos int: Integer.sum(a, b) = a + b
     * Paso a paso con (2, 3, 1, 4):
     *   0 + 2 = 2 -> 2 + 3 = 5 -> 5 + 1 = 6 -> 6 + 4 = 10
     */
    public static int totalConReduce(List<Orden> ordenes) {
        return ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .mapToInt(Item::getUnidades)
                .reduce(0, Integer::sum); // Es lo mismo que el sum(). 0 es el valor inicial.
                // Integer::sum -> .reduce(0, (acumulado, unidades) -> acumulado + unidades)
    }
}
