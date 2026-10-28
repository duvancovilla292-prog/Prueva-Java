package s09lab05;

/**
 * Paso de trabajo del dominio. Es visible solo dentro del paquete: lo crea y
 * administra una OrdenTrabajo y no se transfiere a otra. Guarda su propio estado.
 */
class Paso {
    private final String descripcion;
    // Estado propio del paso (false por defecto = pendiente). Es independiente del vínculo con la orden.
    private boolean completado;

    // Constructor de paquete: solo OrdenTrabajo lo invoca.
    Paso(String descripcion) {
        this.descripcion = descripcion;
    }

    // Marca el paso como completado. Devuelve false si ya lo estaba.
    boolean completar() {
        if (completado) {
            return false;
        }
        completado = true;
        return true;
    }

    // Consulta de estado usada por OrdenTrabajo para contar pendientes.
    boolean estaCompletado() {
        return completado;
    }

    // Texto de estado: descripción y si está completado o pendiente.
    String resumen() {
        return descripcion + ": " + (completado ? "completado" : "pendiente");
    }
}
