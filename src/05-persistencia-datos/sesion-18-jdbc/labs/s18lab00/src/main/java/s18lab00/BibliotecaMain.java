package s18lab00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BibliotecaMain {
    private static final int MAX_TITULO = 150; // tamaño de la columna titulo
    private static final int MAX_ISBN = 20;    // tamaño de la columna isbn

    // Datos de conexión guardados como constantes (igual que en los demos).
    // static final: pertenecen a la clase y no se pueden cambiar después de asignarse.
    private static final String URL = "jdbc:mysql://localhost:3306/campus_java_s18";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Campus2023!";

    // Abre una conexión nueva a MySQL usando las constantes de arriba
    static Connection conectar() throws SQLException {
        // DriverManager.getConnection(...) abre la conexión con la base usando el driver (Connector/J).
        // Ejemplo aquí: devuelve la Connection que usaremos para todas las consultas del menú.
        return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
    }

    // Guarda un libro nuevo en la tabla libros
    static void registrar(Connection con, String titulo, String isbn) {
        // .strip() quita los espacios del inicio y del final de un texto.
        // Ejemplo aquí: "  El principito " queda como "El principito".
        titulo = titulo.strip();
        isbn = isbn.strip();

        // .isBlank() es true si el texto está vacío o solo tiene espacios.
        // Ejemplo aquí: rechaza título o ISBN vacíos antes de tocar la base.
        if (titulo.isBlank() || isbn.isBlank()) {
            System.out.println("El título y el ISBN son obligatorios.");
            return;
        }

        // .length() devuelve cuántos caracteres tiene un texto.
        // Ejemplo aquí: comprueba que el título no pase de 150 y el ISBN no pase de 20.
        if (titulo.length() > MAX_TITULO || isbn.length() > MAX_ISBN) {
            System.out.println("Título máximo " + MAX_TITULO + " caracteres e ISBN máximo " + MAX_ISBN + ".");
            return;
        }

        // Cada ? es un parámetro: un hueco que se llena después, así el usuario nunca se pega al SQL.
        // Ejemplo aquí: los dos ? serán el título y el ISBN del libro.
        String sql = "INSERT INTO libros (titulo, isbn) VALUES (?, ?)";

        // try-with-resources: cierra solos los recursos abiertos entre paréntesis al terminar el bloque.
        // Ejemplo aquí: el PreparedStatement se cierra aunque ocurra un error.
        // con.prepareStatement(sql) prepara la sentencia SQL para ejecutarla con parámetros.
        // Ejemplo aquí: prepara el INSERT con sus dos huecos.
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // setString(posición, valor) llena un parámetro con un texto; las posiciones empiezan en 1.
            // Ejemplo aquí: el 1 es el título y el 2 es el ISBN (el ISBN es texto, no número).
            ps.setString(1, titulo);
            ps.setString(2, isbn);

            // executeUpdate() ejecuta INSERT/UPDATE/DELETE y devuelve cuántas filas cambió.
            // Ejemplo aquí: devuelve 1 si el libro se insertó.
            int filas = ps.executeUpdate();
            System.out.println("Filas insertadas: " + filas);
        } catch (SQLException e) {
            // getMessage() devuelve el texto del error.
            // Ejemplo aquí: si el ISBN ya existe, UNIQUE rechaza el INSERT y se muestra el motivo;
            // el menú sigue funcionando y no se anuncia éxito.
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }

    // Muestra todos los libros guardados
    static void listar(Connection con) {
        // ORDER BY id ordena el resultado por la columna id.
        // Ejemplo aquí: los libros salen en el orden en que se registraron.
        String sql = "SELECT id, titulo, isbn FROM libros ORDER BY id";

        // executeQuery() ejecuta un SELECT y devuelve un ResultSet (las filas encontradas).
        // Ejemplo aquí: rs contiene todos los libros de la tabla.
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            boolean hay = false;

            // rs.next() mueve el cursor a la siguiente fila y devuelve false cuando no quedan más.
            // El cursor empieza ANTES de la primera fila, por eso se llama next() antes de leer.
            // Ejemplo aquí: el while recorre un libro por vuelta.
            while (rs.next()) {
                hay = true;
                // rs.getInt("col") y rs.getString("col") leen el valor de esa columna en la fila actual.
                // Ejemplo aquí: arma la línea "id | titulo | isbn".
                System.out.println(rs.getInt("id") + " | " + rs.getString("titulo") + " | " + rs.getString("isbn"));
            }

            // Si el while nunca entró, la tabla estaba vacía.
            // Ejemplo aquí: se muestra "Sin libros." como mensaje normal.
            if (!hay) {
                System.out.println("Sin libros.");
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }

    // Busca un libro por su ISBN
    static void buscar(Connection con, String isbn) {
        // WHERE isbn = ? filtra solo las filas cuyo isbn sea el valor del parámetro.
        // Ejemplo aquí: devuelve a lo sumo un libro porque el ISBN es UNIQUE.
        String sql = "SELECT id, titulo, isbn FROM libros WHERE isbn = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // setString llena el ? con el ISBN que escribió el usuario (seguro contra inyección SQL).
            // Ejemplo aquí: si escribe 9780156012195, el WHERE busca ese ISBN.
            ps.setString(1, isbn.strip());

            // try-with-resources también sirve para el ResultSet: se cierra al salir del bloque.
            // Ejemplo aquí: rs se cierra solo después de leer el resultado.
            try (ResultSet rs = ps.executeQuery()) {
                // if (rs.next()) comprueba si existe al menos una fila.
                // Ejemplo aquí: si hay fila, se muestra el libro; si no, "Sin resultados." (no es un error).
                if (rs.next()) {
                    System.out.println(rs.getInt("id") + " | " + rs.getString("titulo") + " | " + rs.getString("isbn"));
                } else {
                    System.out.println("Sin resultados.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // new Scanner(System.in) lee lo que el usuario escribe en la consola.
        try (Scanner teclado = new Scanner(System.in);
             Connection con = conectar()) {

            // isValid(5) pregunta a la base si la conexión sigue viva, esperando máximo 5 segundos.
            // Ejemplo aquí: si responde false, salimos antes de mostrar el menú.
            if (!con.isValid(5)) {
                System.out.println("La conexión no es válida.");
                return;
            }
            System.out.println("Conectado a MySQL.");

            boolean salir = false;
            while (!salir) {
                System.out.println("\n1) Registrar  2) Listar  3) Buscar ISBN  4) Salir");
                System.out.print("Opción: ");

                // nextLine() lee una línea completa escrita por el usuario.
                // Ejemplo aquí: guarda la opción elegida en el menú.
                String opcion = teclado.nextLine().strip();

                // .equals() compara el CONTENIDO de dos textos (no su dirección en memoria) y da true/false.
                // Ejemplo aquí: compara lo escrito con "1", "2", "3" o "4" para decidir qué acción hacer.
                if (opcion.equals("1")) {
                    System.out.print("Título: ");
                    String titulo = teclado.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = teclado.nextLine();
                    registrar(con, titulo, isbn);
                } else if (opcion.equals("2")) {
                    listar(con);
                } else if (opcion.equals("3")) {
                    System.out.print("ISBN a buscar: ");
                    buscar(con, teclado.nextLine());
                } else if (opcion.equals("4")) {
                    salir = true; // la conexión se cierra al salir, no dentro de cada método
                } else {
                    System.out.println("Opción no válida.");
                }
            }
            System.out.println("Hasta pronto.");
        } catch (SQLException e) {
            // Aquí caen los fallos al conectar (credenciales incorrectas o base apagada).
            System.out.println("No se pudo conectar: " + e.getMessage());
        }
    }
}
