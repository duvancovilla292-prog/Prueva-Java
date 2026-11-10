package s18lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/campus_java_s18";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Campus2023!";

    public Connection crear() throws SQLException {
        // DriverManager.getConnection(...) abre la conexión con la base usando el driver.
        // Ejemplo aquí: cada operación del DAO recibe su propia Connection y la cierra al terminar.
        return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
    }
}
