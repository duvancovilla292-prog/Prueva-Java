public class Lab02OrdenaLaSalida {
    public static void main(String[] args) {
        // TODO 1: Predecir la salida de estas tres instrucciones en un comentario.
        /*
           saldria esto:
           AB
           C
        */

        // TODO 2: Ejecutar y explicar cualquier diferencia con tu predicción.
        System.out.print("A");
        System.out.println("B");
        System.out.println("C")
        /*
           - System.out.print("A") imprime "A" y mantiene el cursor en la misma línea.
           - System.out.println("B") imprime "B" al lado de la "A" (formando "AB") y luego hace un salto de línea.
           - System.out.println("C") imprime "C" en la siguiente línea y hace un salto final.
        */

        // TODO 3: Modificar las instrucciones anteriores para obtener: A - B - C
        System.out.print("A - ");
        System.out.print("B - ");
        System.out.println("C");

        // TODO 4: Agregar debajo una segunda línea que diga "Fin del laboratorio".
        System.out.println("Fin del laboratorio");

        // TODO 5: Explicar qué instrucción produce cada salto de línea.
        /*
           - System.out.println("C"): Produce el primer salto de línea despus de imprimir la "C",
             moviendo el cursor a la lnea inferior.
           - System.out.println("Fin del laboratorio"): Produce el segundo salto de línea al terminar
             de imprimir el texto final
        */
    }
}