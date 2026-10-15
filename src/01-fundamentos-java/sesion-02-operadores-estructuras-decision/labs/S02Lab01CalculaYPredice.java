public class S02Lab01CalculaYPredice {
    public static void main(String[] args) {
        int unidades = 7;
        int capacidad = 2;
        int contador = 3;

        // TODO 1 & 7: Predicción inicial registrada
        /*
           Predicciones para unidades = 7, capacidad = 2:
           - Suma: 9
           - Resto: 5
           - Producto: 14
           - División entera: 3 (trunca los decimales por operar exclusivamente con enteros)
           - Resto (Módulo): 1 (7 % 2 = 1)
           - División decimal (7.0 / 2): 3.5
           - Precedencia (2 + 3 * 4): 14 (la multiplicación se ejecuta antes que la suma)
           - Precedencia con paréntesis ((2 + 3) * 4): 20 (los paréntesis fuerzan la suma primero)
           - Contador incrementado: 4
           - Contador decrementado: 3
        */

        // TODO 2: Calcular y mostrar suma, resta, producto, división entera y resto.
        System.out.println("=== OPERACIONES BÁSICAS ===");
        System.out.println("Suma: " + (unidades + capacidad));
        System.out.println("Resta: " + (unidades - capacidad));
        System.out.println("Producto: " + (unidades * capacidad));
        System.out.println("División entera: " + (unidades / capacidad));
        System.out.println("Resto (Módulo): " + (unidades % capacidad));

        // TODO 3: Mostrar 7.0 / capacidad y explicar por qué conserva decimales.
        System.out.println("\n=== DIVISIÓN CON DECIMALES ===");
        System.out.println("7.0 / capacidad = " + (7.0 / capacidad));
        /*
           Explicación: Al involucrar un literal de tipo double (7.0), Java realiza una
           promoción de tipos implícita, transformando toda la expresión en una operación
           de punto flotante y evitando el truncamiento entero.
        */

        // TODO 4: Comparar 2 + 3 * 4 con (2 + 3) * 4.
        System.out.println("\n=== PRECEDENCIA DE OPERADORES ===");
        System.out.println("2 + 3 * 4 = " + (2 + 3 * 4));          // Da 14 (multiplicación prioritaria)
        System.out.println("(2 + 3) * 4 = " + ((2 + 3) * 4));      // Da 20 (paréntesis prioritarios)

        // TODO 5: Incrementar contador en una sentencia, mostrarlo; decrementar y mostrarlo.
        System.out.println("\n=== INCREMENTO Y DECREMENTO ===");
        contador++;
        System.out.println("Contador incrementado: " + contador);
        contador--;
        System.out.println("Contador decrementado: " + contador);

        // TODO 6 (opcional): Probar unidades = 8 y explicar qué cambia. Mantener capacidad = 2.
        System.out.println("\n=== CASO OPCIONAL (unidades = 8) ===");
        int unidadesAlternativa = 8;
        System.out.println("División entera (8 / 2): " + (unidadesAlternativa / capacidad));
        System.out.println("Resto (8 % 2): " + (unidadesAlternativa % capacidad));
        /*
           Explicación: Al cambiar unidades a 8, la división entera pasa a ser exacta (4)
           y el resto (módulo) se vuelve 0, ya que 8 es múltiplo exacto de 2.
        */

        // TODO 7: Registro final de validación.
        /*
           Resultado: Las predicciones coincidieron al 100% con la ejecución real.
           No se registraron discrepancias técnicas.
        */
    }
}