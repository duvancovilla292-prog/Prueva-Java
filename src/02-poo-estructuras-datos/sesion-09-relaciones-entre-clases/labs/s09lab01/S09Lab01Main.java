package s09lab01;

/**
 * Escenario de ejecución del Lab 01 (no forma parte del diagrama del dominio).
 */
public class S09Lab01Main {
    public static void main(String[] args) {
        // El Cliente se crea fuera de los consultores: existe de forma independiente.
        Cliente tienda = new Cliente("Tienda Norte");
        Consultor ana = new Consultor("Ana");
        Consultor luis = new Consultor("Luis");

        // Estado inicial: Ana todavía no tiene cliente.
        System.out.println(ana.resumen());
        // La MISMA instancia "tienda" se asigna a dos consultores (se comparte).
        ana.asignarCliente(tienda);
        luis.asignarCliente(tienda);
        System.out.println(ana.resumen());
        System.out.println(luis.resumen());

        // Liberar a Ana no afecta a Luis ni destruye al cliente.
        ana.liberarAsignacion();
        System.out.println("Tras liberar a Ana:");
        System.out.println(ana.resumen());
        System.out.println(luis.resumen());
        System.out.println("Cliente original: " + tienda.getNombre());
        // Asignar null se rechaza y Luis conserva su cliente actual.
        System.out.println("Asignar null: " + luis.asignarCliente(null));
        System.out.println(luis.resumen());
    }
}
