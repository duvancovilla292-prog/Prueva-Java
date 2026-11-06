package s17lab01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class S17Lab01BitacoraMain {
    public static boolean registrar(Path archivo) throws IOException {
        // createDirectories: asegura que la carpeta del archivo exista
        Files.createDirectories(archivo.getParent());
        // newBufferedWriter: abre el archivo para escribir texto; CREATE lo crea si no existe
        // y APPEND agrega al final (sin borrar lo anterior, a diferencia de truncar).
        // try-with-resources: cierra el writer solo al terminar el bloque
        try (BufferedWriter escritor = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            // write: escribe el texto; newLine: agrega el salto de línea
            escritor.write("Revisión eléctrica");
            escritor.newLine();
            escritor.write("Limpieza de área común");
            escritor.newLine();
        }
        // true solo llega aquí si todo se escribió y el archivo se cerró bien
        return true;
    }

    public static void main(String[] args) throws IOException {
        // Si no hay argumento usa la carpeta temporal del sistema; Path.of arma la ruta
        Path base = args.length == 0 ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "lab01") : Path.of(args[0]);
        // toAbsolutePath + normalize: ruta completa y limpia
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        Path archivo = base.resolve("mantenimiento.txt");
        // exists + readAllLines: cuenta las líneas que ya había (0 si el archivo no existe)
        int antes = Files.exists(archivo)
                ? Files.readAllLines(archivo, StandardCharsets.UTF_8).size() : 0;
        if (!registrar(archivo)) {
            System.out.println("PENDIENTE: completar TODO 1 y 2");
            return;
        }
        System.out.println("Antes: " + antes);
        // Se vuelve a leer para contar las líneas tras escribir
        System.out.println("Despues: " + Files.readAllLines(archivo, StandardCharsets.UTF_8).size());
        // readString: lee todo el archivo como un solo texto y lo muestra
        System.out.print(Files.readString(archivo, StandardCharsets.UTF_8));
    }
}