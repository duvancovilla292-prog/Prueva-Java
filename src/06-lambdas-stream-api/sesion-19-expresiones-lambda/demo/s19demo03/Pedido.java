package s19demo03;

/*
 * CLASE Pedido
 * ------------
 * Una clase es un "molde" para crear objetos. Cada objeto Pedido
 * representa un pedido con un codigo y un total.
 *
 * Ejemplo:
 *   Pedido p = new Pedido("A", 100_000);
 *   p.getCodigo(); // "A"
 *   p.getTotal();  // 100000
 */
public class Pedido {

    // Atributos privados y finales: no se ven desde afuera y no cambian
    // despues de crear el objeto (objeto INMUTABLE).
    private final String codigo; // identificador del pedido, ej: "A"
    private final int total;     // valor del pedido, ej: 100000

    /*
     * CONSTRUCTOR: se ejecuta con "new Pedido(...)".
     * Valida los datos antes de guardarlos:
     *   - codigo == null     -> no hay texto
     *   - codigo.isBlank()   -> texto vacio o solo espacios, ej: "   "
     *   - total < 0          -> total negativo
     * Si algo falla lanza IllegalArgumentException.
     *
     * Ejemplo:
     *   new Pedido(" B ", 50)  -> guarda codigo "B" (strip quita espacios)
     *   new Pedido("", 50)     -> error
     */
    public Pedido(String codigo, int total) {
        if (codigo == null || codigo.isBlank() || total < 0) {
            throw new IllegalArgumentException("Codigo obligatorio y total no negativo.");
        }
        // strip(): elimina espacios al inicio y al final. "  A " -> "A"
        this.codigo = codigo.strip();
        this.total = total;
    }

    /*
     * GETTER: metodo que permite LEER un atributo privado desde afuera.
     * Ejemplo: new Pedido("A", 10).getCodigo() -> "A"
     */
    public String getCodigo() {
        return codigo;
    }

    /*
     * GETTER del total.
     * Ejemplo: new Pedido("A", 10).getTotal() -> 10
     */
    public int getTotal() {
        return total;
    }

    /*
     * toString(): define como se ve el objeto al imprimirlo.
     * @Override porque reemplaza el toString() que toda clase hereda de Object
     * (sin esto se imprimiria algo como "Pedido@1b6d3586").
     * Ejemplo: System.out.println(new Pedido("A", 10)); // imprime "A:10"
     */
    @Override
    public String toString() {
        return codigo + ":" + total;
    }
}
