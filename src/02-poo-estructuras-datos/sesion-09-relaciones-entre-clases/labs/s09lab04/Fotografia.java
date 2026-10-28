package s09lab04;

/**
 * Fotografía del dominio: existe antes que los álbumes y puede aparecer en
 * varios a la vez. No guarda referencia a ningún Album.
 */
public class Fotografia {
    // Título inmutable asignado en el constructor.
    private final String titulo;

    public Fotografia(String titulo) {
        this.titulo = titulo;
    }

    // Lo usa Album para su resumen y el Main para consultar las originales.
    public String getTitulo() {
        return titulo;
    }
}
