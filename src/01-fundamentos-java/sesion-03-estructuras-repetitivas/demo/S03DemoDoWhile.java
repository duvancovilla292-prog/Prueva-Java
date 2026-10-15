public class S03DemoDoWhile {
    public static void main(String[] args) {
        int limite = 3;
        int contadorWhile = 5;
        int contadorDoWhile = 5;

        System.out.println("Prueba while");
        while (contadorWhile <= limite) {
            System.out.println("While: " + contadorWhile);
            contadorWhile++;
        }

        System.out.println("Prueba do-while");
        do {
            System.out.println("Do-while: " + contadorDoWhile);
            contadorDoWhile++;
        } while (contadorDoWhile <= limite);

        System.out.println("Final while: " + contadorWhile);
        System.out.println("Final do-while: " + contadorDoWhile);
        // Variables separadas permiten comparar el mismo estado inicial.
    }
}
