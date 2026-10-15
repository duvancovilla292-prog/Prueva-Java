public class S02Lab02ReglasDeAcceso {
    public static void main(String[] args) {
        int edad = 18;
        boolean esMiembro = false;
        boolean tieneInvitacion = true;
        boolean bloqueado = false;

        // TODO 1: Escribir la regla de acceso en lenguaje natural.
        /*
           Regla de acceso:
           Una persona puede entrar si NO está bloqueada Y (es mayor o igual de edad
           O es miembro O tiene una invitación).
        */

        // TODO 2: Construir puedeEntrar combinando edad, membresía, invitación y bloqueo.
        boolean puedeEntrar = !bloqueado && (edad >= 18 || esMiembro || tieneInvitacion);

        // TODO 3: Mostrar "Acceso permitido" o "Acceso denegado" con if/else.
        if (puedeEntrar) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso denegado");
        }

        // TODO 4: Probar los tres casos mínimos del README.
        /*
           Caso A (Por defecto): edad = 18, miembro = false, invitacion = true, bloqueado = false
           -> Resultado esperado: Acceso permitido.

           Caso B (Bloqueado activo): edad = 25, miembro = true, invitacion = true, bloqueado = true
           -> Resultado esperado: Acceso denegado (el bloqueo anula cualquier otra condición).

           Caso C (Sin privilegios ni mayoría de edad): edad = 16, miembro = false, invitacion = false, bloqueado = false
           -> Resultado esperado: Acceso denegado.
        */

        // TODO 5: Explicar por qué el bloqueo impide siempre el acceso.
        /*
           Explicación técnica:
           El bloqueo se conecta mediante el operador lógico AND (`&&`) y se antepone negado (`!bloqueado`).
           Debido a la evaluación de cortocircuito (short-circuit evaluation) en Java, si `bloqueado` es true,
           `!bloqueado` se convierte en false. Al evaluar una conjunción (`false && ...`), el resultado global
           de la expresión será estrictamente false sin importar si el resto de condiciones se cumplen o no.
        */

        // TODO 6 (opcional): Registro del Breakpoint y evaluación de condiciones.
        /*
           - Acción: Colocar un breakpoint en la línea del `if (puedeEntrar)`.
           - Observación en el Debugger: Inspeccionar la variable booleana `puedeEntrar` antes de que
             el flujo decida qué rama ejecutar, verificando cómo se combinan las variables atómicas.
        */
    }
}