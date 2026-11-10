package s19lab01;

import java.util.function.Consumer;

// Lab01: recibe un nombre (String) y solo muestra un mensaje (void) -> Consumer<String>
// Se ejecuta con accept(nombre)
public class S19Lab01AvisoLavanderiaMain {
    public static void main(String[] args) {
        // Acción: imprime el aviso, no devuelve nada
        Consumer<String> avisarCliente = nombre -> System.out.println("Tu pedido esta listo, " + nombre);

        // Nombres de prueba
        String[] nombres = {"Ana", "Luis", "Sara"};
        for (String nombre : nombres) {
            // accept() ejecuta la acción, una línea por llamada
            avisarCliente.accept(nombre);
        }

        // Imprimir no es devolver: println solo lo escribe en consola.
        // accept() es void, así que NO se puede hacer: String texto = avisarCliente.accept("Ana");
    }
}
