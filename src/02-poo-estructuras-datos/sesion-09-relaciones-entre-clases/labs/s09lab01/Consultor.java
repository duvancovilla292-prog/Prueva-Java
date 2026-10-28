package s09lab01;

/**
 * Consultor del dominio. Mantiene un enlace opcional hacia un Cliente
 * mediante el campo "cliente" (0..1). La relación es una asociación dirigida:
 * Consultor conoce a Cliente, pero Cliente no conoce a Consultor.
 */
public class Consultor {
    private final String nombre;
    // Campo que sostiene la relación: apunta a un Cliente externo o es null (sin cliente).
    private Cliente cliente;

    public Consultor(String nombre) {
        this.nombre = nombre;
    }

    // Recibe un Cliente ya existente (no lo crea). Rechaza null y, si es válido,
    // reemplaza cualquier asignación anterior. Devuelve si se aceptó el enlace.
    public boolean asignarCliente(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        this.cliente = cliente;
        return true;
    }

    // Solo suelta la referencia: el Cliente sigue existiendo y otros consultores
    // pueden seguir usándolo.
    public void liberarAsignacion() {
        cliente = null;
    }

    // Texto de estado: consulta el nombre del cliente a través de su getter.
    public String resumen() {
        if (cliente == null) {
            return nombre + ": sin cliente";
        }
        return nombre + ": " + cliente.getNombre();
    }
}
