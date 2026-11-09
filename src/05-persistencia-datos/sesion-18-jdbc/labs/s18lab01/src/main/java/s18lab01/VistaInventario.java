package s18lab01;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

// VISTA: solo consola (menú, entradas y mensajes). No usa java.sql ni SQL.
public class VistaInventario {
    // Scanner lee lo que el usuario escribe en la consola.
    // Ejemplo aquí: con UTF-8 se conservan tildes y la ñ.
    private final Scanner teclado = new Scanner(System.in, StandardCharsets.UTF_8);

    // Muestra el menú y devuelve la opción escrita
    public String mostrarMenu() {
        System.out.println("\n1) Registrar  2) Listar  3) Cambiar stock  4) Salir");
        System.out.print("Opción: ");
        // nextLine() lee una línea completa y .strip() quita espacios sobrantes.
        // Ejemplo aquí: devuelve "1", "2", "3" o "4" ya limpio.
        return teclado.nextLine().strip();
    }

    // Pregunta un texto y lo devuelve
    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    // Pregunta un entero; devuelve null si lo escrito no es un número entero
    public Integer pedirEntero(String mensaje) {
        System.out.print(mensaje);
        String texto = teclado.nextLine().strip();
        try {
            // Integer.parseInt convierte un texto a número entero y lanza NumberFormatException si no puede.
            // Ejemplo aquí: "7" pasa a 7, pero "abc" cae en el catch y devuelve null.
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Muestra la lista de productos como "id | nombre | stock"
    public void mostrarProductos(List<Producto> productos) {
        // .isEmpty() es true cuando la lista no tiene elementos.
        // Ejemplo aquí: si no hay productos se muestra "Sin productos.".
        if (productos.isEmpty()) {
            System.out.println("Sin productos.");
            return;
        }
        // for-each recorre la lista elemento por elemento.
        // Ejemplo aquí: imprime una línea por producto; para cambiar el separador solo se edita este texto.
        for (Producto p : productos) {
            System.out.println(p.getId() + " | " + p.getNombre() + " | " + p.getStock());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }
}
