package s15lab02;

import java.util.Objects;

// Tarea que prepara un certificado para una persona
public final class PrepararCertificado implements Runnable {
    private final String nombre; // nombre de la persona

    public PrepararCertificado(String nombre) {
        // El nombre no puede ser null ni vacío
        this.nombre = Objects.requireNonNull(nombre);
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre vacio");
        }
    }

    // Muestra el certificado y el hilo que lo atiende
    @Override
    public void run() {
        System.out.println(nombre + " atendido por " + Thread.currentThread().getName());
    }
}
