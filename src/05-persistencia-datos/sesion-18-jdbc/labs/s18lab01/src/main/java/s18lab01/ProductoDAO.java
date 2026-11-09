package s18lab01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO: el ÚNICO lugar con SQL. Convierte filas de la tabla en objetos Producto y al revés.
// Las SQLException se propagan (throws) para que el controlador comunique el fallo real.
public class ProductoDAO {
    private final ConexionFactory fabrica;

    public ProductoDAO(ConexionFactory fabrica) {
        this.fabrica = fabrica;
    }

    // Devuelve todos los productos ordenados por id
    public List<Producto> listar() throws SQLException {
        // ORDER BY id ordena el resultado por la columna id.
        // Ejemplo aquí: los productos salen en el orden en que se crearon.
        String sql = "SELECT id, nombre, stock FROM productos ORDER BY id";
        List<Producto> lista = new ArrayList<>();

        // try-with-resources: cierra solos Connection, PreparedStatement y ResultSet al terminar.
        // Ejemplo aquí: los tres se cierran aunque haya un error, sin escribir finally.
        // fabrica.crear() abre una conexión nueva; prepareStatement prepara el SQL; executeQuery lo ejecuta.
        // Ejemplo aquí: rs trae las filas encontradas.
        try (Connection con = fabrica.crear();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // rs.next() mueve el cursor a la siguiente fila y devuelve false cuando se acaban.
            // El cursor empieza antes de la primera fila.
            // Ejemplo aquí: cada vuelta del while es un producto de la tabla.
            while (rs.next()) {
                // rs.getInt / rs.getString leen una columna de la fila actual.
                // lista.add(x) agrega un elemento al final de la lista.
                // Ejemplo aquí: convierte la fila en un Producto y lo guarda en la lista.
                lista.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getInt("stock")));
            }
        }
        // Si no hubo filas la lista queda vacía (eso es normal); si hubo un error ya se lanzó la excepción.
        return lista;
    }

    // Inserta un producto nuevo y devuelve las filas afectadas
    public int insertar(Producto producto) throws SQLException {
        // Cada ? es un parámetro que se llena después (evita concatenar texto del usuario en el SQL).
        // Ejemplo aquí: los dos ? serán el nombre y el stock.
        String sql = "INSERT INTO productos (nombre, stock) VALUES (?, ?)";

        try (Connection con = fabrica.crear();
             PreparedStatement ps = con.prepareStatement(sql)) {
            // setString(pos, texto) y setInt(pos, número) llenan los ?; las posiciones empiezan en 1.
            // Ejemplo aquí: 1 es el nombre (texto) y 2 es el stock (número).
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getStock());

            // executeUpdate() ejecuta INSERT/UPDATE/DELETE y devuelve cuántas filas cambió.
            // Ejemplo aquí: devuelve 1 cuando el producto se guardó.
            return ps.executeUpdate();
        }
    }

    // Cambia el stock de UN producto usando su id; devuelve las filas afectadas
    public int actualizarStock(int id, int stock) throws SQLException {
        // WHERE id = ? limita el UPDATE a la fila con ese id (nunca por nombre, que puede repetirse).
        // Ejemplo aquí: solo cambia el producto elegido, no los demás.
        String sql = "UPDATE productos SET stock = ? WHERE id = ?";

        try (Connection con = fabrica.crear();
             PreparedStatement ps = con.prepareStatement(sql)) {
            // setInt(pos, número) llena un ? con un entero.
            // Ejemplo aquí: 1 es el nuevo stock y 2 es el id del producto.
            ps.setInt(1, stock);
            ps.setInt(2, id);

            // Ejemplo aquí: devuelve 1 si el id existe y 0 si no hay coincidencias (no es un error).
            return ps.executeUpdate();
        }
    }
}
