public class S06Inventario {
    /*// TODO 1: Declarar existencias como int privado y capacidad como final int privado igual a 100.

    public S06Inventario() {
        // TODO 2: Inicializar las existencias en cero.
    }

    public int getExistencias() {
        // TODO 3: Devolver las existencias actuales.
        return 0; // Retorno provisional: reemplazar.
    }

    public boolean ingresar(int cantidad) {
        // TODO 4: Validar cantidad positiva y espacio disponible antes de sumar.
        return false; // Retorno provisional: reemplazar.
    }

    public boolean retirar(int cantidad) {
        // TODO 5: Validar cantidad positiva y existencias suficientes antes de restar.
        return false; // Retorno provisional: reemplazar.
    }*/
    private int existencias;
    private final int capacidad = 100;

    public S06Inventario() {
        existencias = 0;
    }

    public int getExistencias() {
        return existencias;
    }

    public boolean ingresar(int cantidad) {
        if (cantidad <= 0 || cantidad > capacidad - existencias) {
            return false;
        }
        existencias += cantidad;
        return true;
    }

    public boolean retirar(int cantidad) {
        if (cantidad <= 0 || cantidad > existencias) {
            return false;
        }
        existencias -= cantidad;
        return true;
    }
}
