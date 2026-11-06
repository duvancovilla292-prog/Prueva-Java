package s17lab00;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class S17Lab00BibliotecaMain {
    public static boolean preparar(Path base, String seccion) throws IOException {
        // Set.of(...).contains: valida que la sección sea una de las permitidas
        if (!Set.of("infantil", "ciencia", "arte").contains(seccion)) {
            throw new IllegalArgumentException("Seccion permitida: infantil, ciencia o arte");
        }
        Path carpeta = base.resolve(seccion);
        // createDirectories: crea la carpeta y sus padres; no falla si ya existe
        Files.createDirectories(carpeta);
        // resolve: solo arma la ruta carpeta/inventario.txt, NO crea nada en disco
        Path archivo = carpeta.resolve("inventario.txt");
        try {
            // isDirectory: si la ruta ya es una carpeta, avisamos del conflicto
            if (Files.isDirectory(archivo)) {
                throw new FileAlreadyExistsException(archivo.toString());
            }
            // createFile: crea el archivo vacío; si ya existe lanza excepción y no lo borra
            Files.createFile(archivo);
        } catch (FileAlreadyExistsException error) {
            // isRegularFile: si existe pero no es un archivo normal, es un error real
            if (!Files.isRegularFile(archivo)) {
                throw new IOException("La ruta del inventario no es archivo: " + archivo, error);
            }
        }
        return Files.isDirectory(carpeta) && Files.isRegularFile(archivo);
    }

    public static void main(String[] args) throws IOException {
        // Si no hay argumento usa la carpeta temporal del sistema; Path.of arma la ruta
        Path base = args.length == 0 ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "lab00") : Path.of(args[0]);
        // toAbsolutePath + normalize: ruta completa y sin '..' ni '.'
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        String seccion = "infantil";
        boolean preparado = preparar(base, seccion);
        System.out.println(preparado ? "Seccion preparada: " + seccion : "PENDIENTE: completar TODO 1 y 2");
    }
}