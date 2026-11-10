package s19demo00;

/*
 * INTERFAZ FUNCIONAL
 * ------------------
 * Una interfaz es un "contrato": dice QUE se debe hacer, pero no COMO.
 * Una interfaz FUNCIONAL es una interfaz que tiene UN SOLO metodo abstracto.
 * Gracias a eso, Java permite implementarla con una expresion lambda
 * (una funcion corta y anonima) en lugar de escribir una clase completa.
 *
 * Ejemplo:
 *   ReglaMonto mayorQueCien = monto -> monto > 100;
 *   mayorQueCien.cumple(150); // true
 */
@FunctionalInterface // Anotacion opcional: el compilador da error si agregas un segundo metodo abstracto.
public interface ReglaMonto {

    /*
     * cumple(int monto)
     * Metodo abstracto (sin cuerpo). Recibe un numero entero (monto)
     * y devuelve un boolean (true o false) indicando si el monto cumple la regla.
     * Quien implemente la interfaz decide la condicion.
     *
     * Ejemplo: si la regla es "monto >= 100", entonces cumple(50) -> false.
     */
    boolean cumple(int monto);
}
