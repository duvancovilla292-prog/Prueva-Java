package s09lab04;

import java.util.ArrayList;
import java.util.List;

/**
 * Álbum del dominio. Agrupa fotografías que ya existen (las recibe por
 * parámetro) para presentarlas. Es el "todo" de una agregación con Fotografia.
 */
public class Album {
    private final String nombre;
    // Campo que sostiene la relación: referencias a fotografías externas.
    // Puede estar vacía y no hay límite máximo en el código.
    private final List<Fotografia> fotografias = new ArrayList<>();

    public Album(String nombre) {
        this.nombre = nombre;
    }

    // Incorpora una Fotografia existente. Rechaza null y la misma referencia ya
    // incluida (== compara identidad, no el título).
    public boolean agregar(Fotografia fotografia) {
        if (fotografia == null) {
            return false;
        }
        for (Fotografia actual : fotografias) {
            if (actual == fotografia) {
                return false;
            }
        }
        fotografias.add(fotografia);
        return true;
    }

    // Solo suelta las referencias de ESTE álbum; las fotos originales y los demás
    // álbumes que las usan no se alteran.
    public void vaciar() {
        fotografias.clear();
    }

    // Cantidad actual de fotografías del álbum.
    public int cantidad() {
        return fotografias.size();
    }

    // Texto de estado: nombre, cantidad y títulos de las fotos.
    public String resumen() {
        String texto = nombre + " (" + cantidad() + "):";
        for (Fotografia fotografia : fotografias) {
            texto += " " + fotografia.getTitulo();
        }
        return texto;
    }
}
