package s09lab01;

/**
 * Cliente del dominio. Es la clase "referenciada": no sabe nada de los
 * consultores que lo tienen asignado (no hay referencia de regreso).
 */
public class Cliente {
    // Dato inmutable del cliente: se asigna una sola vez en el constructor.
    private final String nombre;

    // Los escenarios proporcionan nombres válidos y no vacíos.
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    // Único medio para consultar el nombre desde fuera (lo usa Consultor).
    public String getNombre() {
        return nombre;
    }
}
