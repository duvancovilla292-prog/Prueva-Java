package s10lab03;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Registra temperaturas enteras entre -10 y 50 (inclusive) recibidas como texto.
 * Cada intento se acepta o se cuenta como rechazado una sola vez.
 */
public class RegistroTemperaturas {
    // Solo guarda lecturas válidas.
    private final List<Integer> lecturas = new ArrayList<>();
    // Cuenta los intentos fallidos (por cualquier motivo).
    private int rechazadas;

    // Intenta registrar una lectura. true si se aceptó, false si se rechazó.
    public boolean registrar(String texto) {
        // 1) Dato obligatorio ausente: null o en blanco.
        if (texto == null || texto.isBlank()) {
            rechazadas++;
            System.out.println("Rechazada: dato obligatorio");
            return false;
        }
        // 2) Conversión: el error de formato se captura sin detener las siguientes lecturas.
        int valor;
        try {
            // strip permite entradas como " 25 ".
            valor = Integer.parseInt(texto.strip());
        // catch específico: texto no convertible ("abc"). No se inventa un 0.
        } catch (NumberFormatException error) {
            rechazadas++;
            System.out.println("Rechazada: no es entero [" + texto + "]");
            return false;
        }
        // 3) Regla de dominio: el número sí se convirtió, pero está fuera de rango. No es una excepción.
        if (valor < -10 || valor > 50) {
            rechazadas++;
            System.out.println("Rechazada: fuera de rango [" + texto + "]");
            return false;
        }
        // Solo se llega aquí si pasó las tres validaciones; tras un rechazo se sale antes con return false.
        lecturas.add(valor);
        return true;
    }

    public int aceptadas() {
        return lecturas.size();
    }

    public int rechazadas() {
        return rechazadas;
    }

    public String lecturasComoTexto() {
        return lecturas.toString();
    }

    // Sin lecturas no hay promedio; si hay, se formatea con 4 decimales y punto (Locale.ROOT).
    public String promedioComoTexto() {
        if (lecturas.isEmpty()) {
            return "Sin datos";
        }
        // long evita desbordar al sumar.
        long suma = 0;
        for (int valor : lecturas) {
            suma += valor;
        }
        return String.format(Locale.ROOT, "%.4f", (double) suma / lecturas.size());
    }
}
