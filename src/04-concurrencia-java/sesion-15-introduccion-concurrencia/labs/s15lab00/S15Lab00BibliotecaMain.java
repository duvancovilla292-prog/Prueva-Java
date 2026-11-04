package s15lab00;

public class S15Lab00BibliotecaMain {
    public static void main(String[] args) throws InterruptedException {
        // Ejecución directa: run() corre en el hilo main
        TareaBiblioteca directa = new TareaBiblioteca("Consulta directa");
        directa.run();

        // Se crean dos hilos con nombre propio
        Thread prestamo = new Thread(
                new TareaBiblioteca("Validar datos del prestamo"), "prestamos");
        Thread aviso = new Thread(
                new TareaBiblioteca("Preparar borrador de aviso"), "avisos");
        try {
            // Inicia los hilos
            prestamo.start();
            aviso.start();
            // Espera a que ambos terminen
            prestamo.join();
            aviso.join();
            System.out.println("Fin: tareas de biblioteca terminadas");
        } finally {
            // Si alguno sigue vivo, se interrumpe
            if (prestamo.isAlive()) {
                prestamo.interrupt();
            }
            if (aviso.isAlive()) {
                aviso.interrupt();
            }
        }
    }
}
