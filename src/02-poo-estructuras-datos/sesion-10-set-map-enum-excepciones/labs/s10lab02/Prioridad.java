package s10lab02;

/**
 * Prioridad de una incidencia. Cada constante lleva su límite de respuesta en minutos.
 */
public enum Prioridad {
    BAJA(120), MEDIA(60), ALTA(15);

    // Campo final fijado por el constructor para cada constante.
    private final int limiteMinutos;

    // Constructor del enum (implícitamente privado).
    Prioridad(int limiteMinutos) {
        this.limiteMinutos = limiteMinutos;
    }

    // Consulta del límite de la prioridad.
    public int getLimiteMinutos() {
        return limiteMinutos;
    }
}
