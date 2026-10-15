public class S03DemoWhile {
    public static void main(String[] args) {
        int intentos = 0;
        int limite = 3;
        while (intentos < limite) {
            System.out.println("Intento: " + (intentos + 1));
            intentos++;
        }
        System.out.println("Proceso finalizado");
        // Prueba limite=0: la condición inicial es falsa y no se imprime ningún intento.
        // Si omites la actualización, el ciclo no termina; analiza antes de cambiarla.
    }
}
