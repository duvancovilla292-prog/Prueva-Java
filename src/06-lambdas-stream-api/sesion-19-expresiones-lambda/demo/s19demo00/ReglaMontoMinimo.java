package s19demo00;

/*
 * CLASE QUE IMPLEMENTA UNA INTERFAZ (la forma "tradicional", sin lambda)
 * ---------------------------------------------------------------------
 * "implements ReglaMonto" significa que esta clase se compromete a escribir
 * el cuerpo del metodo cumple(...) definido en la interfaz.
 * Esta clase sirve para comparar: hace lo mismo que la lambda
 * "monto -> monto >= minimo", pero ocupando muchas mas lineas.
 *
 * Ejemplo:
 *   ReglaMonto regla = new ReglaMontoMinimo(100);
 *   regla.cumple(120); // true
 */
public class ReglaMontoMinimo implements ReglaMonto {

    // Atributo (variable de la clase).
    // private -> solo se puede usar dentro de esta clase (encapsulamiento).
    // final   -> una vez asignado en el constructor ya no puede cambiar.
    // Ejemplo: si se crea con new ReglaMontoMinimo(500), minimo vale 500 para siempre.
    private final int minimo;

    /*
     * CONSTRUCTOR
     * Metodo especial que se ejecuta al hacer "new ReglaMontoMinimo(...)".
     * Su trabajo es dejar el objeto listo y en un estado valido.
     * Aqui VALIDA que el minimo no sea negativo; si lo es, lanza una excepcion
     * (un error controlado) y el objeto no se crea.
     *
     * Ejemplo:
     *   new ReglaMontoMinimo(1000); // OK
     *   new ReglaMontoMinimo(-5);   // IllegalArgumentException
     */
    public ReglaMontoMinimo(int minimo) {
        if (minimo < 0) {
            // throw: detiene la ejecucion y "lanza" el error a quien llamo.
            throw new IllegalArgumentException("El minimo no puede ser negativo.");
        }
        // this.minimo es el atributo; minimo (sin this) es el parametro recibido.
        this.minimo = minimo;
    }

    /*
     * cumple(int monto)
     * @Override indica que estamos escribiendo el cuerpo del metodo de la interfaz.
     * Devuelve true si el monto es mayor o igual al minimo guardado.
     *
     * Ejemplo con minimo = 100:
     *   cumple(100) -> true
     *   cumple(99)  -> false
     */
    @Override
    public boolean cumple(int monto) {
        return monto >= minimo;
    }
}
