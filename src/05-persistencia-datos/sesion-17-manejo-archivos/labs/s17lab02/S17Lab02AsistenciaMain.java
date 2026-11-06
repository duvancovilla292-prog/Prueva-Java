package s17lab02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class S17Lab02AsistenciaMain {
    public enum Estado { ASISTIO, FALTO, TARDE }

    public static int[] importar(Path archivo) throws IOException {
        int validos = 0;
        int invalidos = 0;
        int numero = 0;
        // newBufferedReader: abre el archivo para leer línea a línea (UTF-8); se cierra solo
        try (BufferedReader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String linea;
            // readLine: devuelve la siguiente línea o null al terminar el archivo
            while ((linea = lector.readLine()) != null) {
                numero++;
                // isBlank: las líneas vacías se ignoran sin contarlas
                if (linea.isBlank()) {
                    continue;
                }
                // equals: ignoramos el encabezado solo si está en la línea 1 y es idéntico
                if (numero == 1 && linea.equals("estudiante;fecha;estado")) {
                    continue; // continue: salta a la siguiente línea sin contarla
                }
                // split(";", -1): separa por ";" y conserva campos vacíos al final
                String[] campos = linea.split(";", -1);
                try {
                    // Deben ser exactamente 3 campos
                    if (campos.length != 3) {
                        throw new IllegalArgumentException("se esperaban 3 campos y hay " + campos.length);
                    }
                    // isBlank: detecta campos vacíos o solo con espacios
                    for (String campo : campos) {
                        if (campo.isBlank()) {
                            throw new IllegalArgumentException("hay un campo vacío");
                        }
                    }
                    String estudiante = campos[0]; // se conserva tal cual (no se usa más adelante)
                    // strip: quita espacios; LocalDate.parse: lanza DateTimeParseException si la fecha es inválida
                    LocalDate fecha = LocalDate.parse(campos[1].strip());
                    // valueOf: convierte el texto al enum; lanza IllegalArgumentException si no existe
                    Estado estado = Estado.valueOf(campos[2].strip());
                    // Solo se cuenta como válido si pasó todas las validaciones
                    validos++;
                } catch (DateTimeParseException | IllegalArgumentException error) {
                    invalidos++; // fila rechazada: se cuenta y se muestra el motivo
                    System.out.println("Linea " + numero + ": " + error.getMessage());
                }
            }
        }
        return new int[]{validos, invalidos};
    }

    public static void main(String[] args) throws IOException {
        // Si no hay argumento usa la carpeta temporal del sistema; Path.of arma la ruta
        Path base = args.length == 0 ? Path.of(System.getProperty("java.io.tmpdir"), "campus-java-s17", "lab02") : Path.of(args[0]);
        // toAbsolutePath + normalize: ruta completa y limpia
        base = base.toAbsolutePath().normalize();
        System.out.println("Datos: " + base);
        // createDirectories: asegura que exista la carpeta de datos
        Files.createDirectories(base);
        Path archivo = base.resolve("asistencia.txt");
        if (args.length < 2 || !args[1].equals("solo-leer")) {
            try {
                // writeString con CREATE_NEW: crea la muestra solo si no existe (no pisa tus cambios)
                Files.writeString(archivo, "estudiante;fecha;estado\n"
                        + "Ana;2026-11-02;ASISTIO\nJosé;2026-11-02;FALTO\n"
                        + "María;2026-11-02\nLuis;fecha;ASISTIO\nSara;2026-11-02;PENDIENTE\n",
                        StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            } catch (FileAlreadyExistsException error) {
                // Ya existía: se conserva el archivo tal como lo dejaste
                System.out.println("Muestra existente conservada");
            }
        }
        int[] resultado = importar(archivo);
        System.out.println("Validos: " + resultado[0] + "; invalidos: " + resultado[1]);
        if (resultado[0] + resultado[1] == 0) {
            System.out.println("Sin registros contados: entrada vacia o TODO pendientes; revisar el archivo");
        }
    }
}