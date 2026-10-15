public class S02DemoOpciones {
    public static void main(String[] args) {
        String tipoEntrega = "EXPRESS";
        long costoClasico;
        switch (tipoEntrega) {
            case "ESTANDAR":
                costoClasico = 500;
                break;
            case "EXPRESS":
                costoClasico = 1_200;
                break;
            case "RECOGIDA":
                costoClasico = 0;
                break;
            default:
                costoClasico = -1;
                break;
        }

        // En esta comparación -1 significa opción desconocida, no un costo real.
        long costoModerno = switch (tipoEntrega) {
            case "ESTANDAR" -> 500;
            case "EXPRESS" -> 1_200;
            case "RECOGIDA" -> 0;
            default -> -1;
        };

        if (costoModerno < 0) {
            System.out.println("Tipo de entrega invalido");
        } else {
            System.out.println("Costo clasico (centavos): " + costoClasico);
            System.out.println("Costo moderno (centavos): " + costoModerno);
            String etiqueta = "RECOGIDA".equals(tipoEntrega) ? "Retiro en tienda" : "Entrega a domicilio";
            System.out.println("Etiqueta: " + etiqueta);
        }
    }
}
