package s16lab00;

public class S16Lab00ReservasMain {
    // Ejecuta la prueba con las dos versiones (metodo y bloque) y muestra resultados
    public static void main(String[] args) throws InterruptedException {
//        int cuposIniciales = 20;
        int cuposIniciales = 30; // Paso 5: 30 cupos para 40 intentos -> 30 reservas y 10 rechazos
        System.out.println("Metodo: " + PruebaReservas.ejecutar(
                new CuposMetodo(cuposIniciales), 4, 10, true));
        System.out.println("Bloque: " + PruebaReservas.ejecutar(
                new CuposBloque(cuposIniciales), 4, 10, true));
    }
}
