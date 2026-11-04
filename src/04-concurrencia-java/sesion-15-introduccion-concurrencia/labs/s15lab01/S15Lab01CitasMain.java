package s15lab01;

public class S15Lab01CitasMain {
    public static void main(String[] args) throws InterruptedException {
        // Primera consulta: termina normal
        ejecutar("Consulta-A", false);
        // Segunda consulta: se cancela
        boolean cancelarSegunda = true;
        ejecutar("Consulta-B", cancelarSegunda);
        System.out.println("Fin: consultas de citas terminadas");
    }

    private static void ejecutar(String nombre, boolean cancelar) throws InterruptedException {
        // Si se va a cancelar, se usa una espera larga para alcanzar a interrumpirla
        ConsultaDisponibilidad consulta = new ConsultaDisponibilidad(cancelar ? 5_000 : 50);
        Thread hilo = new Thread(consulta, nombre);
        try {
            hilo.start();
            // Espera a que la consulta realmente empiece
            consulta.esperarInicio();
            if (cancelar) {
                // Pide al hilo que se detenga
                hilo.interrupt();
            }
            // Espera a que el hilo termine
            hilo.join();
            System.out.println(nombre + ": " + consulta.consultarResultado());
            System.out.println("Vivo tras join: " + hilo.isAlive());
        } finally {
            // Por seguridad, si sigue vivo se interrumpe
            if (hilo.isAlive()) {
                hilo.interrupt();
            }
        }
    }
}
