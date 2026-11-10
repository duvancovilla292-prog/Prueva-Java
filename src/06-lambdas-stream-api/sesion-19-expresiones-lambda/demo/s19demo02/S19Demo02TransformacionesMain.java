package s19demo02;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * DEMO 02: Function y BiFunction (transformar datos)
 * --------------------------------------------------
 * Function<T, R>       -> recibe UN valor tipo T y devuelve un valor tipo R. Metodo: apply(T)
 *                         Ejemplo: Function<Integer, Integer> doble = n -> n * 2;
 *                                  doble.apply(5) -> 10
 * BiFunction<T, U, R>  -> recibe DOS valores (T y U) y devuelve R.        Metodo: apply(T, U)
 *                         Ejemplo: BiFunction<Integer, Integer, Integer> sumar = (a, b) -> a + b;
 *                                  sumar.apply(2, 3) -> 5
 * Nota: en los genericos se usa Integer (clase) en lugar de int (primitivo).
 */
public class S19Demo02TransformacionesMain {

    // main: punto de entrada del programa.
    public static void main(String[] args) {
        // Recibe un String y devuelve un Integer: la cantidad de letras.
        // texto.length() devuelve el numero de caracteres del texto.
        Function<String, Integer> contarLetras = texto -> texto.length();
        System.out.println("Letras de Maria: " + contarLetras.apply("Maria")); // 5

        // Variable que la lambda va a "capturar" (debe ser effectively final).
        int descuento = 10_000;
        // Recibe un precio y devuelve el precio menos el descuento.
        // Ejemplo: aplicarDescuento.apply(50_000) -> 40000
        Function<Integer, Integer> aplicarDescuento = precio -> precio - descuento;
        System.out.println("90000 menos 10000: " + aplicarDescuento.apply(90_000)); // 80000

        // BiFunction: con DOS parametros se necesitan parentesis: (a, b) -> ...
        // Multiplica precio unitario por cantidad para obtener el subtotal.
        BiFunction<Integer, Integer, Integer> calcularSubtotal =
                (precioUnitario, cantidad) -> precioUnitario * cantidad;
        System.out.println("30000 por 2: " + calcularSubtotal.apply(30_000, 2)); // 60000
        System.out.println("30000 por 0: " + calcularSubtotal.apply(30_000, 0)); // 0 (caso borde)

        // REFERENCIA A METODO: String::length es lo mismo que texto -> texto.length()
        // "Clase::metodo" se usa cuando la lambda solo llama a un metodo del parametro.
        Function<String, Integer> contarConReferencia = String::length;

        // Las dos formas producen el mismo resultado.
        System.out.println("Lambda con Java: " + contarLetras.apply("Java"));        // 4
        System.out.println("Referencia con Java: " + contarConReferencia.apply("Java")); // 4
    }
}
