package s09lab02;

/**
 * Escenario de ejecución del Lab 02 (no forma parte del diagrama del dominio).
 */
public class S09Lab02Main {
    public static void main(String[] args) {
        // Los jugadores se crean ANTES y fuera de los equipos.
        Jugador sara = new Jugador("Sara");
        Jugador leo = new Jugador("Leo");
        Equipo azul = new Equipo("Azul");
        Equipo rojo = new Equipo("Rojo");

        // Sara se agrega a dos equipos distintos: la instancia se comparte.
        azul.agregar(sara);
        azul.agregar(leo);
        rojo.agregar(sara);
        System.out.println(azul.resumen());
        System.out.println(rojo.resumen());
        // Repetir la misma referencia en el mismo equipo se rechaza.
        System.out.println("Repetir Sara en Azul: " + azul.agregar(sara));
        // Retirar de Azul no afecta a Rojo ni invalida a Sara.
        System.out.println("Retirar Sara de Azul: " + azul.retirar(sara));
        System.out.println(azul.resumen());
        System.out.println(rojo.resumen());
        System.out.println("Jugador original: " + sara.getNombre());
    }
}
