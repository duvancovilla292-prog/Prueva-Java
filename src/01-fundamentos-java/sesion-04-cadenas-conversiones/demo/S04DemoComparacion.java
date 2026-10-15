public class S04DemoComparacion {
    public static void main(String[] args) {
        // new se usa aquí para comparar dos referencias distintas a propósito.
        String primero = new String("Java");
        String segundo = new String("Java");
        System.out.println("Misma referencia: " + (primero == segundo));
        System.out.println("Mismo contenido: " + primero.equals(segundo));
        String opcion = " si ";
        System.out.println("Confirma: " + opcion.strip().equalsIgnoreCase("SI"));
    }
}
