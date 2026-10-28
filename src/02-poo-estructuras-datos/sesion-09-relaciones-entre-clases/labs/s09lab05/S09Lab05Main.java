package s09lab05;

/**
 * Escenario de ejecución del Lab 05 (no forma parte del diagrama del dominio).
 */
public class S09Lab05Main {
    public static void main(String[] args) {
        OrdenTrabajo primera = new OrdenTrabajo("OT-01");
        OrdenTrabajo segunda = new OrdenTrabajo("OT-02");
        // Cada orden crea sus propios pasos a partir de descripciones.
        primera.agregarPaso("Revisar cable");
        primera.agregarPaso("Probar encendido");
        segunda.agregarPaso("Limpiar filtro");
        System.out.println(primera.resumen());
        System.out.println(segunda.resumen());
        // Completar el índice 0 funciona; repetirlo o usar un índice fuera de rango se rechaza.
        System.out.println("Completar indice 0: " + primera.completarPaso(0));
        System.out.println("Repetir indice 0: " + primera.completarPaso(0));
        System.out.println("Completar indice 8: " + primera.completarPaso(8));
        // OT-02 no cambia: los pasos no se comparten entre órdenes.
        System.out.println(primera.resumen());
        System.out.println(segunda.resumen());
    }
}
