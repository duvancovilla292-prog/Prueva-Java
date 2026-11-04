package s15lab01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Tarea que simula consultar disponibilidad de citas y puede cancelarse
public final class ConsultaDisponibilidad implements Runnable {
    // Estados posibles de la consulta
    private enum Estado {
        NO_INICIADA, EN_CURSO, COMPLETADA, CANCELADA
    }

    private final long esperaMs; // tiempo que tarda la consulta
    // Señal para avisar que la consulta ya comenso
    private final CountDownLatch inicio = new CountDownLatch(1);
    private Estado estado = Estado.NO_INICIADA;

    public ConsultaDisponibilidad(long esperaMs) {
        // Validación del tiempo de espera
        if (esperaMs < 0 || esperaMs > 5_000) {
            throw new IllegalArgumentException("Espera entre 0 y 5000 ms");
        }
        this.esperaMs = esperaMs;
    }

    // Espera (máximo 5 segundos) a que la consulta empiece
    public void esperarInicio() throws InterruptedException {
        // Una senal evita intentar acertar el inicio mediante sleep o espera activa.
        if (!inicio.await(5, TimeUnit.SECONDS)) {
            throw new IllegalStateException("La consulta no inicio en el plazo previsto");
        }
    }

    // Código que ejecuta el hilo
    @Override
    public void run() {
        estado = Estado.EN_CURSO;
        // Avisa que la consulta ya inició
        inicio.countDown();
        try {
            // Revisa si fue interrumpida antes de empezar
            if (Thread.currentThread().isInterrupted()) {
                estado = Estado.CANCELADA;
                return;
            }
            // Simula el tiempo de la consulta
            Thread.sleep(esperaMs);
            // Revisa de nuevo si fue interrumpida
            if (Thread.currentThread().isInterrupted()) {
                estado = Estado.CANCELADA;
                return;
            }
            estado = Estado.COMPLETADA;
        } catch (InterruptedException error) {
            // Si la interrumpen durante sleep, se marca como cancelada
            Thread.currentThread().interrupt();
            estado = Estado.CANCELADA;
        }
    }

    // Leer desde main solo despues de join: no es una consulta concurrente del progreso.
    public String consultarResultado() {
        return estado.name();
    }
}
