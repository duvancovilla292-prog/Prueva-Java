package s20demo02;

/*
 * CLASE Item
 * ----------
 * Representa un producto dentro de una orden: un nombre y cuantas unidades se piden.
 * Es un objeto INMUTABLE: sus datos no cambian despues de crearlo.
 *
 * Ejemplo:
 *   Item i = new Item("Cuaderno", 2);
 *   i.getNombre();   // "Cuaderno"
 *   i.getUnidades(); // 2
 */
public class Item {

    // Atributos privados (encapsulamiento) y finales (no cambian una vez asignados).
    private final String nombre;   // ej: "Lapiz"
    private final int unidades;    // ej: 3

    /*
     * CONSTRUCTOR: se ejecuta con "new Item(...)".
     * Valida los datos antes de guardarlos:
     *   - nombre == null     -> no hay texto
     *   - nombre.isBlank()   -> texto vacio o solo espacios, ej: "   "
     *   - unidades < 0       -> cantidad negativa
     * Si algo falla lanza IllegalArgumentException y el objeto no se crea.
     *
     * Ejemplo:
     *   new Item(" Lapiz ", 3) -> guarda nombre "Lapiz" (strip quita espacios)
     *   new Item("Lapiz", -1)  -> error
     */
    public Item(String nombre, int unidades) {
        if (nombre == null || nombre.isBlank() || unidades < 0) {
            throw new IllegalArgumentException("Nombre obligatorio y unidades no negativas.");
        }
        // strip(): elimina espacios al inicio y al final. "  Lapiz " -> "Lapiz"
        this.nombre = nombre.strip();
        this.unidades = unidades;
    }

    /*
     * GETTER del nombre: permite LEER el atributo privado desde afuera.
     * En el demo se usa como referencia a metodo: Item::getNombre
     * Ejemplo: new Item("Lapiz", 3).getNombre() -> "Lapiz"
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * GETTER de las unidades.
     * En el demo se usa como referencia a metodo: Item::getUnidades
     * Ejemplo: new Item("Lapiz", 3).getUnidades() -> 3
     */
    public int getUnidades() {
        return unidades;
    }

    /*
     * toString(): define como se ve el objeto al imprimirlo.
     * @Override porque reemplaza el toString() heredado de Object.
     * Ejemplo: System.out.println(new Item("Lapiz", 3)); // imprime "Lapiz:3"
     */
    @Override
    public String toString() {
        return nombre + ":" + unidades;
    }
}
