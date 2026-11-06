package s16lab00;

public final class CuposBloque implements Cupos {
    private int disponibles;
    // Candado privado: nadie de afuera puede bloquearlo
    private final Object monitor = new Object();

    // Constructor: valida y guarda los cupos iniciales
    public CuposBloque(int disponibles) {
        if (disponibles < 0 || disponibles > 1_000_000) {
            throw new IllegalArgumentException("Disponibles entre 0 y 1000000");
        }
        this.disponibles = disponibles;
    }

    // Usa un bloque synchronized(monitor): revisar y descontar quedan protegidos juntos
    @Override
    public boolean reservar() {
        synchronized (monitor) {
            if (disponibles <= 0) {
                return false;
            }
            int observado = disponibles;
            disponibles = observado - 1;
            return true;
        }
    }

    // Lee los cupos usando el mismo monitor
    @Override
    public int consultarDisponibles() {
        synchronized (monitor) {
            return disponibles;
        }
    }
}
