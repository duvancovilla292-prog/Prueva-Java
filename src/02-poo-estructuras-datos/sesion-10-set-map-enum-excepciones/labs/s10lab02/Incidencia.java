package s10lab02;

/**
 * Incidencia con una prioridad fija y los minutos transcurridos sin responder.
 */
public class Incidencia {
    // La prioridad (enum) decide el límite; no se usa ordinal() ni se comparan Strings.
    private final Prioridad prioridad;
    private int minutosTranscurridos;

    // No se permite crear una incidencia sin prioridad.
    public Incidencia(Prioridad prioridad) {
        if (prioridad == null) {
            // Unchecked: impide que exista un objeto inválido.
            throw new IllegalArgumentException("La prioridad es obligatoria");
        }
        this.prioridad = prioridad;
    }

    // Registra un tiempo ABSOLUTO (reemplaza el anterior, no suma). Los negativos se rechazan.
    public boolean registrarMinutos(int minutos) {
        if (minutos < 0) {
            return false;
        }
        minutosTranscurridos = minutos;
        return true;
    }

    // Vencida solo si SUPERA el límite (>): en el límite exacto todavía no está vencida.
    public boolean estaVencida() {
        // El límite lo entrega la propia constante del enum.
        return minutosTranscurridos > prioridad.getLimiteMinutos();
    }

    public int getMinutosTranscurridos() {
        return minutosTranscurridos;
    }

    // Texto como "ALTA 16 min: vencida=true".
    public String resumen() {
        return prioridad.name() + " " + minutosTranscurridos
                + " min: vencida=" + estaVencida();
    }
}
