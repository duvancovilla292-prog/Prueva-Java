package s18lab01;

// MODELO: representa un producto y valida sus propias reglas (sin consola ni SQL).
public class Producto {
    private static final int MAX_NOMBRE = 100;

    private final int id;       // 0 cuando el producto aún no está en la base
    private final String nombre;
    private final int stock;

    // Producto nuevo (todavía sin id: MySQL lo asigna con AUTO_INCREMENT)
    public Producto(String nombre, int stock) {
        this(0, nombre, stock);
    }

    // Producto leído de la base (ya tiene id)
    public Producto(int id, String nombre, int stock) {
        // .isBlank() es true si el texto está vacío o solo tiene espacios (antes comprobamos que no sea null).
        // Ejemplo aquí: un nombre vacío o de puros espacios se rechaza con un mensaje claro.
        if (nombre == null || nombre.isBlank()) {
            // IllegalArgumentException avisa que un dato recibido no es válido.
            // Ejemplo aquí: el controlador la atrapa y la vista muestra el mensaje.
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        // .strip() quita espacios al inicio y al final; .length() cuenta los caracteres.
        // Ejemplo aquí: " Cuaderno " pasa a "Cuaderno" y se verifica que no pase de 100.
        String limpio = nombre.strip();
        if (limpio.length() > MAX_NOMBRE) {
            throw new IllegalArgumentException("El nombre admite hasta " + MAX_NOMBRE + " caracteres.");
        }
        validarStock(stock);
        this.id = id;
        this.nombre = limpio;
        this.stock = stock;
    }

    // Regla de stock reutilizable: también la usa el controlador al actualizar
    public static void validarStock(int stock) {
        // Ejemplo aquí: stock < 0 no es válido (la base también lo exige con CHECK).
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }
}
