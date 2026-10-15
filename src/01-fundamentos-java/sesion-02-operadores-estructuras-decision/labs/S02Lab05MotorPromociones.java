public class S02Lab05MotorPromociones {
    public static void main(String[] args) {
        long subtotalCentavos = 18_500;
        int cantidad = 4;
        boolean esMiembro = true;
        String tipoEntrega = "EXPRESS";

        // TODO 1: Predicción inicial (para subtotal = 18500, cantidad = 4, miembro = true, entrega = EXPRESS)
        /*
           - Subtotal: 18500 centavos
           - Descuento: 10% (por ser miembro y cantidad > 3) -> 1850 centavos
           - Importe neto: 18500 - 1850 = 16650 centavos
           - Envío (EXPRESS base): 1200 centavos
           - Total general: 16650 + 1200 = 17850 centavos
        */

        // TODO 2: Validar subtotal entre 0 y 1_000_000 inclusive y cantidad mayor que cero.
        boolean subtotalValido = (subtotalCentavos >= 0 && subtotalCentavos <= 1_000_000);
        boolean cantidadValida = (cantidad > 0);

        if (!subtotalValido || !cantidadValida) {
            System.out.println("Error: Datos de entrada invalidos");
            return;
        }

        // TODO 3: Rechazar entrega desconocida (ESTANDAR, EXPRESS, RECOGIDA permitidas).
        long envioBaseCentavos = switch (tipoEntrega) {
            case "ESTANDAR" -> 500;
            case "EXPRESS" -> 1200;
            case "RECOGIDA" -> 0;
            default -> -1; // Centinela para entrega inválida
        };

        if (envioBaseCentavos == -1) {
            System.out.println("Tipo de entrega invalido");
            return;
        }

        // TODO 4: Elegir porcentaje de descuento con if/else if/else
        // Reglas de ejemplo:
        // - 10% si es miembro y cantidad > 3
        // - 5% si es miembro O cantidad > 3
        // - 0% en cualquier otro caso
        int porcentajeDescuento = 0;
        if (esMiembro && cantidad > 3) {
            porcentajeDescuento = 10;
        } else if (esMiembro || cantidad > 3) {
            porcentajeDescuento = 5;
        } else {
            porcentajeDescuento = 0;
        }

        // TODO 5: Calcular descuento y neto en centavos; truncar fracciones de centavo (división entera con long).
        long descuentoCentavos = (subtotalCentavos * porcentajeDescuento) / 100;
        long netoCentavos = subtotalCentavos - descuentoCentavos;

        // TODO 6: Aplicar gratuidad de envío solo al ESTANDAR cuando el neto alcanza >= 25000 centavos.
        long envioFinalCentavos = envioBaseCentavos;
        if (tipoEntrega.equals("ESTANDAR") && netoCentavos >= 25_000) {
            envioFinalCentavos = 0;
        }

        long totalCentavos = netoCentavos + envioFinalCentavos;

        // TODO 7: Mostrar el desglose con etiquetas limpias.
        System.out.println("=== DESGLOSE DE PROMOCIONES Y PAGOS ===");
        System.out.println("Subtotal (centavos): " + subtotalCentavos);
        System.out.println("Descuento (" + porcentajeDescuento + "%): -" + descuentoCentavos + " centavos");
        System.out.println("Importe Neto (centavos): " + netoCentavos);
        System.out.println("Costo de envio (centavos): " + envioFinalCentavos);
        System.out.println("Total a pagar (centavos): " + totalCentavos);

        // TODO 8: Pruebas de casos mínimos validadas correctamente.
        // TODO 9: (Opcional - Depuración) Inspección de variables clave en breakpoint exitosa.
        // TODO 10: Nombres normalizados y legibles listos para ejecución en producción.
    }
}