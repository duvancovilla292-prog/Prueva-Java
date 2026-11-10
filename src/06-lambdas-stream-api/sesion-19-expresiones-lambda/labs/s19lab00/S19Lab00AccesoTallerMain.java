package s19lab00;

import java.util.function.Predicate;

// Lab00: recibe una edad (Integer) y responde true/false -> Predicate<Integer>
// Se ejecuta con test(edad)
public class S19Lab00AccesoTallerMain {
    public static void main(String[] args) {
        int edadMinima = 15;

        // Regla: puede entrar si tiene 15 años o más (definirla NO la ejecuta)
        Predicate<Integer> puedeIngresar = edad -> edad >= edadMinima;

        // Edades de prueba
        int[] edades = {14, 15, 20};
        for (int edad : edades) {
            // test() es el que ejecuta la lambda
            System.out.println(edad + " | puede ingresar=" + puedeIngresar.test(edad));
        }

        // Por qué Predicate: recibe un dato y solo responde si cumple o no la condición.
        // El método que ejecuta la lambda es test().
    }
}
