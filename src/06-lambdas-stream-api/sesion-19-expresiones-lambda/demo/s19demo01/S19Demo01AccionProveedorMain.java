package s19demo01;

// Interfaces funcionales que ya trae Java en el paquete java.util.function.
// No hace falta crearlas nosotros.
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
 * DEMO 01: Supplier (proveedor) y Consumer (consumidor)
 * -----------------------------------------------------
 * Supplier<T>  -> NO recibe nada y DEVUELVE un valor de tipo T.   Metodo: get()
 *                 Ejemplo: Supplier<Integer> dado = () -> 6;  dado.get() -> 6
 * Consumer<T>  -> RECIBE un valor de tipo T y NO devuelve nada.   Metodo: accept(T)
 *                 Ejemplo: Consumer<String> saludar = n -> System.out.println("Hola " + n);
 *                          saludar.accept("Ana"); // imprime "Hola Ana"
 * La <T> entre <> se llama "generico": indica el tipo de dato con el que trabaja.
 */
public class S19Demo01AccionProveedorMain {

    // main: punto de entrada del programa.
    public static void main(String[] args) {
        // Supplier: "()" significa que no recibe parametros. Devuelve el texto.
        // OJO: definir la lambda NO la ejecuta; solo se ejecuta al llamar get().
        Supplier<String> mensajeInicial = () -> "Pedido recibido";

        // Consumer: recibe "mensaje" y hace una accion (imprimir). No retorna nada.
        Consumer<String> mostrarAviso = mensaje -> System.out.println("AVISO: " + mensaje);

        System.out.println("1. Comportamientos definidos; todavia no se solicito el mensaje.");

        // get(): AHORA si se ejecuta el Supplier y obtenemos su valor.
        String mensaje = mensajeInicial.get(); // mensaje = "Pedido recibido"
        System.out.println("2. Valor suministrado: " + mensaje);

        // accept(...): ejecuta el Consumer con el valor dado.
        mostrarAviso.accept(mensaje); // imprime "AVISO: Pedido recibido"

        System.out.println("3. Solicitar y mostrar otra vez:");
        // Se pueden encadenar: el resultado de get() se pasa directo a accept().
        mostrarAviso.accept(mensajeInicial.get());

        // Lambda que solo pasa el valor a otro metodo...
        Consumer<String> imprimirLambda = texto -> System.out.println(texto);

        // ...se puede escribir como REFERENCIA A METODO con "::".
        // System.out::println significa "usa el metodo println de System.out".
        // Es equivalente a: texto -> System.out.println(texto)
        Consumer<String> imprimirReferencia = System.out::println;

        System.out.println("4. Delegacion equivalente:");
        // Ambas imprimen exactamente lo mismo.
        imprimirLambda.accept("Pedido registrado");
        imprimirReferencia.accept("Pedido registrado");
    }
}
