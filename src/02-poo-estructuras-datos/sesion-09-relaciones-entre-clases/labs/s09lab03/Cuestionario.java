package s09lab03;

import java.util.ArrayList;
import java.util.List;

/**
 * Cuestionario del dominio. Es el "todo" de una relación de composición con
 * Pregunta: crea, guarda y administra sus propias preguntas.
 */
public class Cuestionario {
    private final String titulo;
    // Campo que sostiene la relación: lista privada de preguntas propias.
    // Nunca se entrega hacia fuera, así que nadie más puede compartir sus elementos.
    private final List<Pregunta> preguntas = new ArrayList<>();

    public Cuestionario(String titulo) {
        this.titulo = titulo;
    }

    // Recibe solo TEXTO (no una Pregunta) y crea la Pregunta aquí dentro con "new".
    // Rechaza texto nulo o en blanco y guarda el texto sin espacios sobrantes.
    public boolean agregarPregunta(String texto) {
        if (texto == null || texto.isBlank()) {
            return false;
        }
        preguntas.add(new Pregunta(texto.strip()));
        return true;
    }

    // Cantidad actual de preguntas (puede ser 0: se permite un cuestionario vacío).
    public int cantidad() {
        return preguntas.size();
    }

    // Quita todas las preguntas del modelo. Es la decisión del "todo" sobre sus partes;
    // no se interpreta como destruir memoria, y no afecta a otros cuestionarios.
    public void vaciar() {
        preguntas.clear();
    }

    // Texto de estado: título, cantidad y textos entre corchetes.
    public String resumen() {
        String texto = titulo + " (" + cantidad() + "):";
        for (Pregunta pregunta : preguntas) {
            texto += " [" + pregunta.getTexto() + "]";
        }
        return texto;
    }
}
