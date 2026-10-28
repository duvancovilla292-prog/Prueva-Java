package s10lab02;

/**
 * Escenario del Lab 02: prueba los límites de cada prioridad y el rechazo de minutos negativos.
 */
public class S10Lab02EnumMain {
    public static void main(String[] args) {
        // values() recorre BAJA, MEDIA y ALTA en el orden en que se declararon.
        for (Prioridad prioridad : Prioridad.values()) {
            System.out.println(prioridad.name() + ": " + prioridad.getLimiteMinutos() + " min");
        }
        Incidencia alta = new Incidencia(Prioridad.ALTA);
        // ALTA con 15 min: igual al límite, NO está vencida.
        alta.registrarMinutos(15);
        System.out.println(alta.resumen());
        // Con 16 min supera el límite de 15: vencida.
        alta.registrarMinutos(16);
        System.out.println(alta.resumen());
        Incidencia media = new Incidencia(Prioridad.MEDIA);
        media.registrarMinutos(45);
        System.out.println(media.resumen());
        Incidencia baja = new Incidencia(Prioridad.BAJA);
        baja.registrarMinutos(121);
        System.out.println(baja.resumen());
        // -1 se rechaza (false) y se conservan los 121 minutos anteriores.
        System.out.println("Minutos negativos: " + baja.registrarMinutos(-1));
        System.out.println(baja.resumen());
    }
}
