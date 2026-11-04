package s15lab02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class S15Lab02ThreadExecutorMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Personas a las que se les prepara certificado
        String[] nombres = {"Ana", "Luis", "Sara"};
        // Forma 1: un Thread por cada tarea
        System.out.println("=== Thread: un hilo nuevo por tarea ===");
        ejecutarConThread(nombres);
        // Forma 2: un pool de hilos reutilizables
        System.out.println("=== Executor: pool de 2 hilos ===");
        ejecutarConExecutor(nombres);
        System.out.println("Fin: todas las tareas terminaron");
    }

    // Crea un hilo nuevo por cada tarea
    private static void ejecutarConThread(String[] nombres) throws InterruptedException {
        List<Thread> hilos = new ArrayList<>();
        try {
            // Crea e inicia cada hilo
            for (int indice = 0; indice < nombres.length; indice++) {
                Thread hilo = new Thread(new PrepararCertificado(nombres[indice]),
                        "manual-" + (indice + 1));
                hilos.add(hilo);
                hilo.start();
            }
            // Espera a que todos los hilos terminen
            for (Thread hilo : hilos) {
                hilo.join();
            }
        } finally {
            // Interrumpe los hilos que sigan vivos
            for (Thread hilo : hilos) {
                if (hilo.isAlive()) {
                    hilo.interrupt();
                }
            }
        }
    }

    // Usa un ExecutorService con 2 hilos para todas las tareas
    private static void ejecutarConExecutor(String[] nombres)
            throws InterruptedException, ExecutionException {
        // Pool fijo de 2 hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Guarda los Future para saber cuándo termina cada tarea
        List<Future<?>> pendientes = new ArrayList<>();
        try {
            // Envía cada tarea al pool
            for (String nombre : nombres) {
                pendientes.add(executor.submit(new PrepararCertificado(nombre)));
            }
            // No acepta nuevas tareas; las ya enviadas siguen ejecutandose.
            executor.shutdown();
            // get() espera a que cada tarea termine
            for (Future<?> pendiente : pendientes) {
                pendiente.get();
            }
            // Espera máximo 5 segundos a que el pool cierre
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                throw new IllegalStateException("El ejecutor no termino en el plazo de cierre");
            }
        } finally {
            // Tambien solicita cierre si get o la espera fallan.
            executor.shutdownNow();
        }
    }
}
