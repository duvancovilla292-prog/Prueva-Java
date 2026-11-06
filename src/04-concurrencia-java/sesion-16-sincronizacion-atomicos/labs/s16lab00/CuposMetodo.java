package s16lab00;

public final class CuposMetodo implements Cupos {
    private int disponibles;

    // Constructor: valida y guarda los cupos iniciales
    public CuposMetodo(int disponibles) {
        if (disponibles < 0 || disponibles > 1_000_000) {
            throw new IllegalArgumentException("Disponibles entre 0 y 1000000");
        }
        this.disponibles = disponibles;
    }

    // synchronized en el metodo: el candado es 'this'. Revisar y descontar ocurre sin interrupciones de otro hilo
    @Override
    public synchronized boolean reservar() {
        if (disponibles <= 0) {
            return false;
        }
        int observado = disponibles;
        disponibles = observado - 1;
        return true;
    }

    // Lee los cupos con el mismo candado para ver el valor actualizado
    @Override
    public synchronized int consultarDisponibles() {
        return disponibles;
    }
}
