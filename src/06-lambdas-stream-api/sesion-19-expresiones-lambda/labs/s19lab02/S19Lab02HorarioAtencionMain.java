package s19lab02;

import java.util.function.Supplier;

// Lab02: no recibe nada y devuelve un texto (String) -> Supplier<String>
// Se ejecuta con get()
public class S19Lab02HorarioAtencionMain {
    public static void main(String[] args) {
        // () -> significa que no recibe argumentos; solo entrega el texto, no imprime
        Supplier<String> horario = () -> "Horario: 8:00 a 17:00";

        // Se solicita el valor tres veces; get() devuelve el texto
        String primera = horario.get();
        System.out.println("Primera: " + primera);

        String segunda = horario.get();
        System.out.println("Segunda: " + segunda);

        // También se puede pedir y mostrar en la misma línea
        System.out.println("Tercera: " + horario.get());

        // Obtener = get() devuelve el texto y lo puedo guardar en una variable.
        // Mostrar = println lo escribe en consola; eso lo decide quien pide el valor.
    }
}
