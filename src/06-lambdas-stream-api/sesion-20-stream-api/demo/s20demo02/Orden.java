package s20demo02;

import java.util.List;
import java.util.Objects;

/*
 * CLASE Orden
 * -----------
 * Representa una orden de compra: un codigo y una LISTA de Items.
 * Es decir, cada Orden "contiene" varios Item (relacion de composicion).
 * Esto crea datos ANIDADOS (una lista de ordenes, donde cada una tiene una lista
 * de items), que es justo lo que el demo aplana con flatMap.
 *
 * Ejemplo:
 *   Orden o = new Orden("O1", List.of(new Item("Lapiz", 3)));
 *   o.getCodigo(); // "O1"
 *   o.getItems();  // [Lapiz:3]
 */
public class Orden {

    // Atributos privados y finales.
    private final String codigo;     // ej: "O1"
    private final List<Item> items;  // ej: [Cuaderno:2, Lapiz:3]

    /*
     * CONSTRUCTOR: se ejecuta con "new Orden(...)".
     * - Valida que el codigo no sea null ni vacio.
     * - Objects.requireNonNull(items, mensaje): si items es null lanza
     *   NullPointerException con ese mensaje; si no, devuelve el mismo items.
     * - List.copyOf(lista): crea una COPIA INMUTABLE de la lista recibida.
     *   Asi, si quien creo la orden modifica su lista original despues,
     *   la orden no se ve afectada (copia defensiva).
     *
     * Ejemplo:
     *   new Orden("O3", List.of()) -> orden valida sin items
     *   new Orden("O4", null)      -> NullPointerException
     *   new Orden("", List.of())   -> IllegalArgumentException
     */
    public Orden(String codigo, List<Item> items) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo obligatorio.");
        }
        this.codigo = codigo.strip();
        this.items = List.copyOf(Objects.requireNonNull(items, "La lista de items es obligatoria."));
    }

    /*
     * GETTER del codigo.
     * Ejemplo: new Orden("O1", List.of()).getCodigo() -> "O1"
     */
    public String getCodigo() {
        return codigo;
    }

    /*
     * GETTER de los items.
     * Devuelve la lista inmutable, por lo que desde afuera no se puede
     * agregar ni quitar items (llamar a add() lanzaria UnsupportedOperationException).
     * En el demo se usa como referencia a metodo: Orden::getItems
     */
    public List<Item> getItems() {
        return items;
    }
}
