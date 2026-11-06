package s16lab00;

// Contrato comun: cualquier version de cupos debe poder reservar y consultar
public interface Cupos {
    // Intenta tomar un cupo: true si lo logro, false si no quedan
    boolean reservar();
    // Devuelve cuantos cupos quedan
    int consultarDisponibles();
}
