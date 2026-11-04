package s15lab00;

import java.util.Objects;

// Tarea de biblioteca que puede ejecutarse en un hilo
public final class TareaBiblioteca implements Runnable {
    private final String nombre; // nombre de la tarea

    public TareaBiblioteca(String nombre) {
        // El nombre no puede ser null ni vacío
        this.nombre = Objects.requireNonNull(nombre);
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre vacio");
        }
    }

    // Muestra la tarea y el hilo que la ejecuta
    @Override
    public void run() {
        System.out.println(nombre + " atendido por " + Thread.currentThread().getName());
    }
}
