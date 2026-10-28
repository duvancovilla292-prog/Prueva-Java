package s09lab02;

/**
 * Jugador del dominio: existe de forma independiente y puede pertenecer a
 * varios equipos a la vez. No guarda referencia a ningún Equipo.
 */
public class Jugador {
    // Dato inmutable asignado en el constructor.
    private final String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Lo usa Equipo para mostrar a sus jugadores.
    public String getNombre() {
        return nombre;
    }
}
