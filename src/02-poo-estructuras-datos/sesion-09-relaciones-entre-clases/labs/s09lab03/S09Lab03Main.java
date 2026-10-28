package s09lab03;

/**
 * Escenario de ejecución del Lab 03 (no forma parte del diagrama del dominio).
 */
public class S09Lab03Main {
    public static void main(String[] args) {
        Cuestionario java = new Cuestionario("Java");
        Cuestionario git = new Cuestionario("Git");
        // Se pasan textos, no objetos Pregunta: cada cuestionario crea las suyas.
        java.agregarPregunta("Que hace main?");
        java.agregarPregunta("Para que sirve private?");
        git.agregarPregunta("Que hace git pull?");
        System.out.println(java.resumen());
        System.out.println(git.resumen());
        // Un texto en blanco se rechaza y no cambia el conteo.
        System.out.println("Agregar texto en blanco: " + java.agregarPregunta("   "));
        System.out.println("Cantidad Java: " + java.cantidad());
        // Vaciar Java deja a Git intacto: las preguntas no se comparten.
        java.vaciar();
        System.out.println("Tras vaciar Java:");
        System.out.println(java.resumen());
        System.out.println(git.resumen());
    }
}
