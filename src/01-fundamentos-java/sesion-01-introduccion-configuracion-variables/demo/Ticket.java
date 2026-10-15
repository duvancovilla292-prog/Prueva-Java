public class Ticket {
    public static void main(String[] args) {
        String producto = "Cuaderno";
        int cantidad = 3;
        double precioUnitario = 12500.0;
        final double IVA = 0.19;

        double subtotal = cantidad * precioUnitario;
        double impuesto = subtotal * IVA;
        double total = subtotal + impuesto;

        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA: " + impuesto);
        System.out.println("Total: " + total);
    }
}
