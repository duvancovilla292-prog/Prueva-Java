package s09lab02;

import java.util.ArrayList;
import java.util.List;

/**
 * Equipo del dominio. Reúne jugadores que ya existen (los recibe por parámetro)
 * y no los crea. Es el "todo" de una relación de agregación con Jugador.
 */
public class Equipo {
    private final String nombre;
    // Campo que sostiene la relación: lista de referencias a jugadores externos.
    // Puede estar vacía (sin mínimo) y no tiene límite máximo en el código.
    private final List<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    // Incorpora un Jugador existente. Rechaza null y la misma referencia repetida
    // (== compara identidad, no el nombre: dos objetos distintos con igual nombre sí caben).
    public boolean agregar(Jugador jugador) {
        if (jugador == null) {
            return false;
        }
        for (Jugador actual : jugadores) {
            if (actual == jugador) {
                return false;
            }
        }
        jugadores.add(jugador);
        return true;
    }

    // Quita la referencia de ESTE equipo únicamente; el Jugador sigue vivo y
    // sigue en los demás equipos. Devuelve false si no estaba.
    public boolean retirar(Jugador jugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i) == jugador) {
                jugadores.remove(i);
                return true;
            }
        }
        return false;
    }

    // Cantidad actual de jugadores del equipo.
    public int cantidad() {
        return jugadores.size();
    }

    // Texto de estado: nombre, cantidad y nombres de los jugadores.
    public String resumen() {
        String texto = nombre + " (" + cantidad() + "):";
        for (Jugador jugador : jugadores) {
            texto += " " + jugador.getNombre();
        }
        return texto;
    }
}
