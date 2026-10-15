public class S04DemoConversiones {
    public static void main(String[] args) {
        int cantidad = 10;
        double ampliada = cantidad;
        System.out.println("Ampliada: " + ampliada);
        System.out.println("Cast positivo: " + (int) 7.9);
        System.out.println("Cast negativo: " + (int) -7.9);
        int edad = Integer.parseInt(" 21 ".strip());
        double estatura = Double.parseDouble("1.72");
        Integer objeto = Integer.valueOf("42");
        Integer automatico = cantidad;
        int recuperado = automatico;
        System.out.println("Edad: " + edad);
        System.out.println("Estatura: " + estatura);
        System.out.println("Wrapper: " + objeto);
        System.out.println("Unboxing: " + recuperado);
        System.out.println("Texto: [" + String.valueOf(edad) + "]");
        // Solo para observar el diagnóstico, activando una línea por vez en una copia:
        // int invalida = Integer.parseInt("veinte");
        // int sinLimpiar = Integer.parseInt(" 21 ");
        // El cast trunca hacia cero; ampliar hacia punto flotante no siempre conserva precisión.
    }
}
