package s18lab01;

import java.sql.SQLException;
import java.util.List;

// CONTROLADOR: coordina. Pide datos a la vista, valida con el modelo y llama al DAO.
// Flujo: vista -> controlador -> DAO -> MySQL, y los datos regresan por el mismo camino.
public class ProductoController {
    private final VistaInventario vista;
    private final ProductoDAO dao;

    public ProductoController(VistaInventario vista, ProductoDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    // Bucle principal del menú
    public void ejecutar() {
        boolean salir = false;
        while (!salir) {
            String opcion = vista.mostrarMenu();
            try {
                // .equals() compara el CONTENIDO de dos textos (no su dirección en memoria) y da true/false.
                // Ejemplo aquí: compara la opción escrita con "1", "2", "3" o "4" para elegir la acción.
                if (opcion.equals("1")) {
                    registrar();
                } else if (opcion.equals("2")) {
                    listar();
                } else if (opcion.equals("3")) {
                    cambiarStock();
                } else if (opcion.equals("4")) {
                    salir = true;
                } else {
                    vista.mostrarError("Opción no válida.");
                }
            } catch (IllegalArgumentException e) {
                // Datos inválidos detectados por el modelo o el controlador.
                // getMessage() devuelve el texto del error. Ejemplo aquí: "El stock no puede ser negativo."
                vista.mostrarError(e.getMessage());
            } catch (SQLException e) {
                // Fallo real de la base: se informa, nunca se disfraza de lista vacía o de cero.
                vista.mostrarError("Fallo de base de datos: " + e.getMessage());
            }
        }
        vista.mostrarMensaje("Hasta pronto.");
    }

    private void listar() throws SQLException {
        // Ejemplo aquí: el DAO devuelve la List<Producto> y el controlador solo se la entrega a la vista.
        List<Producto> productos = dao.listar();
        vista.mostrarProductos(productos);
    }

    private void registrar() throws SQLException {
        String nombre = vista.pedirTexto("Nombre: ");
        Integer stock = vista.pedirEntero("Stock: ");
        // == null pregunta si no hay valor.
        // Ejemplo aquí: si el usuario no escribió un entero, avisamos y no seguimos.
        if (stock == null) {
            throw new IllegalArgumentException("El stock debe ser un número entero.");
        }
        // new Producto(...) valida nombre y stock en su constructor; si algo falla lanza IllegalArgumentException.
        // Ejemplo aquí: solo un Producto válido llega al DAO.
        Producto producto = new Producto(nombre, stock);
        int filas = dao.insertar(producto);
        vista.mostrarMensaje("Filas afectadas: " + filas);
    }

    private void cambiarStock() throws SQLException {
        Integer id = vista.pedirEntero("Id del producto: ");
        Integer stock = vista.pedirEntero("Nuevo stock: ");
        if (id == null || stock == null) {
            throw new IllegalArgumentException("El id y el stock deben ser números enteros.");
        }
        // Ejemplo aquí: id 0 o negativo se rechaza antes de tocar la base.
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser positivo.");
        }
        // Reutiliza la regla del modelo. Ejemplo aquí: -1 lanza "El stock no puede ser negativo." y no se guarda nada.
        Producto.validarStock(stock);

        int filas = dao.actualizarStock(id, stock);
        // Ejemplo aquí: 0 filas significa que ese id no existe (resultado normal, distinto de un error SQL).
        if (filas == 0) {
            vista.mostrarMensaje("Sin coincidencias para ese id.");
        } else {
            vista.mostrarMensaje("Filas afectadas: " + filas);
        }
    }
}
