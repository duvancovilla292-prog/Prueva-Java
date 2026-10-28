package s09lab03;

/**
 * Pregunta del dominio. Es visible solo dentro del paquete (sin "public"):
 * nadie fuera del modelo puede crearla ni recibirla. Pertenece a un único
 * Cuestionario, que es quien la construye.
 */
class Pregunta {
    // Texto inmutable de la pregunta.
    private final String texto;

    // Constructor de paquete: solo Cuestionario lo invoca.
    Pregunta(String texto) {
        this.texto = texto;
    }

    // Lo usa Cuestionario para armar su resumen.
    String getTexto() {
        return texto;
    }
}
