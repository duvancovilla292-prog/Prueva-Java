public class S02Lab04EligeLaEntrega {
    public static void main(String[] args) {
        String tipoEntrega = "EXPRESS"; // Cambiar para probar: "ESTANDAR", "RECOGIDA", "DRON"

        // TODO 1 & 2: Resolver costos con switch moderno y default como inválido (-1 centinela)
        int costo = switch (tipoEntrega) {
            case "ESTANDAR" -> 500;
            case "EXPRESS" -> 1200;
            case "RECOGIDA" -> 0;
            default -> -1;
        };

        boolean esValido = (costo != -1);

        if (!esValido) {
            // TODO 5: Para inválidos mostrar SOLO "Tipo de entrega invalido"
            System.out.println("Tipo de entrega invalido");
        } else {
            // TODO 3: Mostrar "Costo (centavos): " con el valor
            System.out.println("Costo (centavos): " + costo);

            // TODO 4 & 5: Usar un operador ternario para elegir la modalidad y mostrar "Etiqueta: "
            String modalidad = tipoEntrega.equals("RECOGIDA") ? "Retiro en tienda" : "Entrega a domicilio";
            System.out.println("Etiqueta: " + modalidad);
        }

        // TODO 6: Explicación técnica de break y las flechas (->)
        /*
           Explicación:
           - Switch clásico y `break`: En la sintaxis tradicional de Java, cada `case` requiere un
             `break` obligatorio al final. Si se omite, ocurre el fenómeno de "fall-through", donde
             la ejecución continúa cayendo erróneamente hacia los bloques de los casos inferiores.
           - Switch moderno (`->`): Las flechas introducidas en versiones recientes eliminan por
             completo la necesidad de usar `break`. Cada rama con flecha es autónoma, ejecuta una
             sola instrucción o bloque, y evita de forma nativa los errores por omisión de saltos.
        */
    }
}