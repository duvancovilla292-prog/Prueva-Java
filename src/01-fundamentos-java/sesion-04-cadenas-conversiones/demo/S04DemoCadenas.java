public class S04DemoCadenas {
    public static void main(String[] args) {
        String original = "  Java  ";
        original.strip();
        System.out.println("Sin guardar resultado: [" + original + "]");
        String limpio = original.strip();
        System.out.println("Limpio: [" + limpio + "]");
        System.out.println("Longitud: " + limpio.length());
        if (!limpio.isBlank()) {
            System.out.println("Primer caracter: " + limpio.charAt(0));
        }
        String frase = "El lenguaje Java";
        System.out.println("Subcadena: " + frase.substring(3, 11));
        System.out.println("Original conservado: [" + original + "]");
    }
}
