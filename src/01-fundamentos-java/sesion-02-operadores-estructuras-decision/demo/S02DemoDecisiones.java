public class S02DemoDecisiones {
    public static void main(String[] args) {
        int edad = 18;
        boolean esMiembro = false;
        boolean tieneInvitacion = true;
        boolean bloqueado = false;
        boolean puedeEntrar = edad >= 18 && (esMiembro || tieneInvitacion) && !bloqueado;

        if (puedeEntrar) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso denegado");
        }

        int nota = 90;
        if (nota < 0 || nota > 100) {
            System.out.println("Nota invalida");
        } else if (nota >= 90) {
            System.out.println("Categoria A");
        } else if (nota >= 80) {
            System.out.println("Categoria B");
        } else {
            System.out.println("Categoria inferior a B");
        }

        int divisor = 0;
        // Si divisor es cero, && omite la división que no sería válida.
        boolean cocienteMayorQueDos = divisor != 0 && 10 / divisor > 2;
        System.out.println("Cociente mayor que dos: " + cocienteMayorQueDos);
    }
}
