public class S02Lab03ClasificaResultados {
    public static void main(String[] args) {
        int nota = 85; // Cambiar este valor para probar diferentes casos (ej. 90, 101)

        // TODO 1: Rechazar notas fuera de 0 a 100 antes de clasificarlas.
        if (nota < 0 || nota > 100) {
            System.out.println("Nota invalida");
        } else {
            // TODO 2 & 3: Clasificar con if/else if/else y mostrar "Categoria X"
            if (nota >= 90) {
                System.out.println("Categoria A");
            } else if (nota >= 80) {
                System.out.println("Categoria B");
            } else if (nota >= 70) {
                System.out.println("Categoria C");
            } else if (nota >= 60) {
                System.out.println("Categoria D");
            } else {
                System.out.println("Categoria E");
            }
        }

        // TODO 4: Pruebas requeridas
        /*
           - nota = 85 -> Categoria B
           - nota = 90 -> Categoria A
           - nota = 101 -> Nota invalida
        */

        // TODO 5: Explicación con nota = 95 por qué el orden de las condiciones importa.
        /*
           Explicación técnica:
           Las estructuras condicionales anidadas (if / else if) se evalúan de forma secuencial,
           de arriba hacia abajo, deteniéndose en el primer bloque cuya condición resulte verdadera.
           Si evaluamos `nota = 95` pero invirtiéramos el orden (colocando primero `nota >= 60`),
           la máquina evaluaría si 95 es mayor o igual a 60, lo cual da verdadero de inmediato,
           clasificándolo erróneamente como "Categoria D" en lugar de "Categoria A".
           Por ello, al evaluar rangos inclusivos descendentes, el orden estricto de mayor a menor
           es obligatorio para garantizar la precisión lógica.
        */
    }
}