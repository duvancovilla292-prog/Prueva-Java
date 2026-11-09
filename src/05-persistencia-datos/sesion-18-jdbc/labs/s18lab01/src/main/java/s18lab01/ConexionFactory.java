package s18lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// FÁBRICA: entrega una conexión NUEVA cada vez que se pide (no guarda ninguna global).
public class ConexionFactory {

    public Connection crear() throws SQLException {
        // System.getenv("X") lee una variable de entorno del sistema o de la configuración Run.
        // Ejemplo aquí: lee DB_URL, DB_USER y DB_PASSWORD para que las credenciales no estén en el código.
        String url = System.getenv("DB_URL");
        String usuario = System.getenv("DB_USER");
        String clave = System.getenv("DB_PASSWORD");

        // == null pregunta si la variable no existe.
        // Ejemplo aquí: si falta alguna, lanzamos un error entendible.
        if (url == null || usuario == null || clave == null) {
            throw new SQLException("Faltan variables DB_URL, DB_USER o DB_PASSWORD en Run");
        }

        // DriverManager.getConnection(...) abre la conexión con la base usando el driver.
        // Ejemplo aquí: cada operación del DAO recibe su propia Connection y la cierra al terminar.
        return DriverManager.getConnection(url, usuario, clave);
    }
}
