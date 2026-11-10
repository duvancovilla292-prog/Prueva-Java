package s19demo03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/*
 * DEMO 03: Predicate (reglas) y Comparator (orden)
 * ------------------------------------------------
 * Predicate<T>  -> recibe un T y devuelve boolean (una condicion). Metodo: test(T)
 *                  Ejemplo: Predicate<Integer> esPar = n -> n % 2 == 0;
 *                           esPar.test(4) -> true
 * Comparator<T> -> compara dos objetos T para saber cual va primero. Metodo: compare(a, b)
 *                  Devuelve: numero NEGATIVO si a va antes, 0 si son iguales,
 *                            POSITIVO si a va despues.
 *                  Ejemplo: Comparator<Integer> asc = (a, b) -> Integer.compare(a, b);
 *                           asc.compare(1, 5) -> -1
 */
public class S19Demo03ReglasOrdenMain {

    // main: punto de entrada del programa.
    public static void main(String[] args) {
        // List.of(...) crea una lista inmutable; al envolverla en new ArrayList<>(...)
        // obtenemos una lista que SI se puede modificar.
        // ArrayList: lista de tamano dinamico (crece al agregar elementos).
        List<Pedido> pedidos = new ArrayList<>(List.of(
                new Pedido("A", 100_000),
                new Pedido("B", 80_000),
                new Pedido("C", 100_000)));

        // Predicate: regla "el total es al menos 100000".
        // Ejemplo: cumpleMinimo.test(new Pedido("X", 120_000)) -> true
        Predicate<Pedido> cumpleMinimo = pedido -> pedido.getTotal() >= 100_000;

        // Lista vacia donde guardaremos los pedidos que cumplan la regla.
        List<Pedido> elegibles = new ArrayList<>();
        // Recorremos los pedidos y usamos test() para FILTRAR.
        for (Pedido pedido : pedidos) {
            if (cumpleMinimo.test(pedido)) {
                elegibles.add(pedido); // add(): agrega al final de la lista
            }
        }
        System.out.println("Original: " + pedidos);     // [A:100000, B:80000, C:100000]
        System.out.println("Elegibles: " + elegibles);  // [A:100000, C:100000]

        // COMBINAR PREDICADOS:
        // Regla: total no mayor a 500000.
        Predicate<Pedido> noSuperaMaximo = pedido -> pedido.getTotal() <= 500_000;

        // and(): verdadero solo si se cumplen LAS DOS reglas (como &&).
        // Ejemplo: total 200000 -> en rango (true); total 600000 -> false.
        Predicate<Pedido> enRango = cumpleMinimo.and(noSuperaMaximo);

        // equals(): compara el CONTENIDO de dos textos (no usar == con String).
        Predicate<Pedido> esPromocional = pedido -> pedido.getCodigo().equals("PROMO");

        // or(): verdadero si se cumple AL MENOS UNA de las reglas (como ||).
        Predicate<Pedido> admiteBeneficio = cumpleMinimo.or(esPromocional);

        // get(0): obtiene el elemento en la posicion 0 (el primero) de la lista.
        System.out.println("En rango A: " + enRango.test(pedidos.get(0))); // true
        // PROMO con 80000 no cumple el minimo, pero SI es promocional -> true
        System.out.println("Beneficio PROMO de 80000: "
                + admiteBeneficio.test(new Pedido("PROMO", 80_000)));
        // negate(): invierte la regla (como !). B tiene 80000 -> "no cumple minimo" = true
        System.out.println("No cumple minimo B: " + cumpleMinimo.negate().test(pedidos.get(1)));

        // Copia de la lista para ordenar sin modificar la original.
        List<Pedido> ordenados = new ArrayList<>(pedidos);
        // Obtenemos el criterio de orden desde un metodo (ver mas abajo).
        Comparator<Pedido> criterio = porTotalYCodigo();
        // sort(): ordena la lista usando el Comparator dado.
        ordenados.sort(criterio);
        System.out.println("Orden total/codigo: " + ordenados);  // [B:80000, A:100000, C:100000]
        System.out.println("Original conservada: " + pedidos);   // no cambio

        // Probando compare() directamente:
        // B(80000) vs A(100000): B va antes -> negativo
        System.out.println("Comparar B con A: " + criterio.compare(pedidos.get(1), pedidos.get(0)));
        // A vs A: iguales -> 0
        System.out.println("Comparar A consigo: " + criterio.compare(pedidos.get(0), pedidos.get(0)));
        // C vs A: mismo total, desempata por codigo; "C" va despues de "A" -> positivo
        System.out.println("Comparar C con A: " + criterio.compare(pedidos.get(2), pedidos.get(0)));

        // Variante equivalente: descomenta ambas lineas para comparar el mismo orden.
        // Comparator.comparingInt(Pedido::getTotal) -> ordena por total
        // .thenComparing(Pedido::getCodigo)         -> si empatan, ordena por codigo
        // ordenados.sort(Comparator.comparingInt(Pedido::getTotal).thenComparing(Pedido::getCodigo));
        // System.out.println("Variante: " + ordenados);
    }

    /*
     * porTotalYCodigo()
     * Devuelve un Comparator escrito como lambda de DOS parametros con bloque { }.
     * Regla de orden:
     *   1) Primero por total, de menor a mayor.
     *   2) Si el total es igual (empate), por codigo en orden alfabetico.
     *
     * Integer.compare(a, b): devuelve negativo si a<b, 0 si a==b, positivo si a>b.
     *   Ejemplo: Integer.compare(80, 100) -> -1
     * String.compareTo(otro): compara textos alfabeticamente.
     *   Ejemplo: "A".compareTo("C") -> negativo (A va antes)
     */
    public static Comparator<Pedido> porTotalYCodigo() {
        return (primero, segundo) -> {
            int porTotal = Integer.compare(primero.getTotal(), segundo.getTotal());
            // Si los totales son distintos, ya sabemos el orden.
            if (porTotal != 0) {
                return porTotal;
            }
            // Empate en total: desempatamos por codigo.
            return primero.getCodigo().compareTo(segundo.getCodigo());
        };
    }
}
