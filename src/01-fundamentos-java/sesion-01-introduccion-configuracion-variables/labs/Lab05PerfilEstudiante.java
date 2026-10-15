public class Lab05PerfilEstudiante {
    public static void main(String[] args) {
        // TODO 1: Identificar los tipos de nombre, edad, ciudad, promedio y activo.
        // - nombre: String
        // - edad: int
        // - ciudad: String
        // - promedio: double
        // - activo: boolean

        // TODO 2: Declarar e inicializar esos datos con nombres claros.
        String nombre = "Ciel Covilla";
        int edad = 18;
        String ciudad = "Cúcuta";
        double promedio = 4.6;
        boolean activo = true;

        // TODO 3: Declarar final String CURSO con el valor "Java".
        final String CURSO = "Java";

        // TODO 4: Mostrar la ficha inicial con etiquetas legibles.
        System.out.println("=== FICHA DE ESTUDIANTE ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Promedio: " + promedio);
        System.out.println("Activo: " + activo);
        System.out.println("Curso: " + CURSO);
        System.out.println("---------------------------");

        // TODO 5: Reasignar ciudad para representar un cambio de residencia y mostrar
        // "Ciudad actualizada: " con el nuevo valor, conservando el mismo tipo.
        ciudad = "Medellín";
        System.out.println("Ciudad actualizada: " + ciudad);

        // TODO 6: Probar el perfil A del README.
        // (Perfil A ejecutado correctamente con los datos especificados).

        // TODO 7: Registro del Breakpoint y Step Over (Debugging).
        /*
           - Valor anterior de ciudad (antes de la reasignación): "Cúcuta"
           - Acción: Aplicar "Step Over" sobre la línea de reasignación.
           - Valor nuevo de ciudad (después de ejecutar la instrucción): "Medellín"
        */

        // TODO 8: Explicación de elección de tipo y garantía de final.
        /*
           - Elección de tipo: Se utiliza `double` para el promedio porque permite almacenar
             valores con precisión decimal (como 4.6), a diferencia de `int` que trunca los decimales.
           - Garantía de `final`: La palabra reservada `final` en `CURSO` bloquea la variable
             para que actúe como una constante inmutable, previniendo cualquier intento accidental
             de modificar su valor a lo largo de la ejecución del programa.
        */
    }
}