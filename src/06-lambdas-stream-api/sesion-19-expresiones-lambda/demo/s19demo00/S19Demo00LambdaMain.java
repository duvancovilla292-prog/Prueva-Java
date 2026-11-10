package s19demo00;

/*
 * DEMO 00: Clase tradicional vs. expresion lambda
 * -----------------------------------------------
 * Una EXPRESION LAMBDA es una forma corta de escribir una funcion sin nombre.
 * Sintaxis:  (parametros) -> resultado
 *   Ejemplo: x -> x * 2      // recibe x y devuelve el doble
 * Solo se puede usar donde Java espera una interfaz funcional (como ReglaMonto).
 */
public class S19Demo00LambdaMain {

    /*
     * main: punto de entrada del programa. Java empieza a ejecutar aqui.
     * String[] args son los argumentos que se pueden pasar desde la terminal (aqui no se usan).
     */
    public static void main(String[] args) {
        // Variable local. 100_000 es lo mismo que 100000; el "_" solo ayuda a leer.
        int minimo = 100_000;

        // Forma 1 (tradicional): crear un objeto de una clase que implementa la interfaz.
        ReglaMonto explicita = new ReglaMontoMinimo(minimo);

        // Forma 2 (lambda): misma regla en una sola linea.
        //   monto          -> parametro (equivale al int monto de cumple)
        //   ->             -> "se convierte en" / "devuelve"
        //   monto >= minimo -> lo que retorna (true/false)
        // La lambda "captura" la variable minimo de afuera.
        // Ejemplo: lambda.cumple(200_000) -> true
        ReglaMonto lambda = monto -> monto >= minimo;

        // EFFECTIVELY FINAL: una lambda solo puede usar variables locales que NUNCA
        // cambian despues de asignarse (aunque no tengan la palabra final).
        // Si descomentas esta reasignacion, minimo deja de ser effectively final
        // y el programa NO compila.
        // minimo = 200_000;

        // Arreglo (array): lista de tamano fijo. Aqui guarda 3 montos para probar.
        int[] montos = {150_000, 99_999, 100_000};

        // for-each: recorre el arreglo; en cada vuelta "monto" toma el siguiente valor.
        // Ejemplo: 1a vuelta monto=150000, 2a vuelta monto=99999, 3a vuelta monto=100000.
        for (int monto : montos) {
            // Ambas reglas deben dar el mismo resultado: demuestran que son equivalentes.
            System.out.println(monto + " | clase=" + evaluar(monto, explicita)
                    + " | lambda=" + evaluar(monto, lambda));
        }

        // Lambda con BLOQUE { }: cuando hay llaves, se necesita escribir "return"
        // explicitamente. Util cuando la logica tiene varias lineas.
        // Equivale a: monto -> monto > 0
        ReglaMonto positiva = monto -> {
            return monto > 0;
        };
        // Se llama al metodo de la interfaz normalmente; se ejecuta el cuerpo de la lambda.
        System.out.println("Positivo 25: " + positiva.cumple(25));   // true
        System.out.println("Positivo -3: " + positiva.cumple(-3));   // false
    }

    /*
     * evaluar(int monto, ReglaMonto regla)
     * static -> se puede llamar sin crear un objeto de la clase.
     * Recibe un monto y una REGLA (un comportamiento) como parametro.
     * Esto es la idea clave de las lambdas: pasar "comportamiento" a un metodo
     * igual que pasamos un numero o un texto.
     *
     * Ejemplo:
     *   evaluar(50, m -> m > 10) -> true
     *   evaluar(5,  m -> m > 10) -> false
     */
    public static boolean evaluar(int monto, ReglaMonto regla) {
        return regla.cumple(monto);
    }
}
