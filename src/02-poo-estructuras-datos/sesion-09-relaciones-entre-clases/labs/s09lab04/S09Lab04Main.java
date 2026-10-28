package s09lab04;

/**
 * Escenario de ejecución del Lab 04 (no forma parte del diagrama del dominio).
 */
public class S09Lab04Main {
    public static void main(String[] args) {
        // Las fotografías se crean primero y fuera de los álbumes.
        Fotografia playa = new Fotografia("Playa");
        Fotografia montana = new Fotografia("Montana");
        Album vacaciones = new Album("Vacaciones");
        Album favoritas = new Album("Favoritas");
        // "playa" se comparte entre dos álbumes.
        vacaciones.agregar(playa);
        vacaciones.agregar(montana);
        favoritas.agregar(playa);
        System.out.println(vacaciones.resumen());
        System.out.println(favoritas.resumen());
        // Vaciar Vacaciones no cambia Favoritas ni las fotos originales.
        vacaciones.vaciar();
        System.out.println("Tras vaciar Vacaciones:");
        System.out.println(vacaciones.resumen());
        System.out.println(favoritas.resumen());
        System.out.println("Fotos originales: " + playa.getTitulo() + ", " + montana.getTitulo());
    }
}
