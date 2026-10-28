package s09lab05;

import java.util.ArrayList;
import java.util.List;

/**
 * Orden de trabajo del dominio. Es el "todo" de una relación de composición
 * con Paso: crea, guarda y administra sus propios pasos.
 */
public class OrdenTrabajo {
    private final String codigo;
    // Campo que sostiene la relación: lista privada de pasos propios.
    // No hay métodos para insertar un Paso externo ni para obtener sus referencias.
    private final List<Paso> pasos = new ArrayList<>();

    public OrdenTrabajo(String codigo) {
        this.codigo = codigo;
    }

    // Recibe solo una DESCRIPCIÓN y crea el Paso aquí dentro con "new".
    // Rechaza texto nulo o en blanco.
    public boolean agregarPaso(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            return false;
        }
        pasos.add(new Paso(descripcion.strip()));
        return true;
    }

    // Valida el rango del índice y le pide al paso que se complete.
    // Devuelve false si el índice no existe o el paso ya estaba completado.
    public boolean completarPaso(int indice) {
        if (indice < 0 || indice >= pasos.size()) {
            return false;
        }
        return pasos.get(indice).completar();
    }

    // Cuenta los pasos que aún no se han completado.
    public int pendientes() {
        int cantidad = 0;
        for (Paso paso : pasos) {
            if (!paso.estaCompletado()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Texto de estado: código, pendientes y el resumen de cada paso.
    public String resumen() {
        String texto = codigo + " - pendientes: " + pendientes();
        for (Paso paso : pasos) {
            texto += " [" + paso.resumen() + "]";
        }
        return texto;
    }
}
